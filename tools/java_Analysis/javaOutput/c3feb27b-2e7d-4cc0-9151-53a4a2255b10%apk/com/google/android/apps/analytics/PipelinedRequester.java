package com.google.android.apps.analytics;

import android.util.Log;
import java.io.IOException;
import java.net.Socket;
import org.apache.http.Header;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.params.BasicHttpParams;

class PipelinedRequester
{
  private static final int RECEIVE_BUFFER_SIZE = 8192;
  PipelinedRequester.Callbacks callbacks;
  boolean canPipeline = true;
  DefaultHttpClientConnection connection = new DefaultHttpClientConnection();
  HttpHost host;
  int lastStatusCode;
  SocketFactory socketFactory;

  public PipelinedRequester(HttpHost paramHttpHost)
  {
    this(paramHttpHost, new PlainSocketFactory());
  }

  public PipelinedRequester(HttpHost paramHttpHost, SocketFactory paramSocketFactory)
  {
    this.host = paramHttpHost;
    this.socketFactory = paramSocketFactory;
  }

  private void closeConnection()
  {
    if ((this.connection != null) && (this.connection.isOpen()));
    try
    {
      this.connection.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  private void maybeOpenConnection()
    throws IOException
  {
    if ((this.connection == null) || (!this.connection.isOpen()))
    {
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      Socket localSocket1 = this.socketFactory.createSocket();
      Socket localSocket2 = this.socketFactory.connectSocket(localSocket1, this.host.getHostName(), this.host.getPort(), null, 0, localBasicHttpParams);
      localSocket2.setReceiveBufferSize(8192);
      this.connection.bind(localSocket2, localBasicHttpParams);
    }
  }

  public void addRequest(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
    throws HttpException, IOException
  {
    maybeOpenConnection();
    this.connection.sendRequestHeader(paramHttpEntityEnclosingRequest);
    this.connection.sendRequestEntity(paramHttpEntityEnclosingRequest);
  }

  public void finishedCurrentRequests()
  {
    closeConnection();
  }

  public void installCallbacks(PipelinedRequester.Callbacks paramCallbacks)
  {
    this.callbacks = paramCallbacks;
  }

  public void sendRequests()
    throws IOException, HttpException
  {
    this.connection.flush();
    HttpConnectionMetrics localHttpConnectionMetrics = this.connection.getMetrics();
    do
    {
      HttpResponse localHttpResponse;
      if (localHttpConnectionMetrics.getResponseCount() < localHttpConnectionMetrics.getRequestCount())
      {
        localHttpResponse = this.connection.receiveResponseHeader();
        if (!localHttpResponse.getStatusLine().getProtocolVersion().greaterEquals(HttpVersion.HTTP_1_1))
        {
          this.callbacks.pipelineModeChanged(false);
          this.canPipeline = false;
        }
        Header[] arrayOfHeader = localHttpResponse.getHeaders("Connection");
        if (arrayOfHeader != null)
        {
          int i = arrayOfHeader.length;
          for (int j = 0; j < i; j++)
            if ("close".equalsIgnoreCase(arrayOfHeader[j].getValue()))
            {
              this.callbacks.pipelineModeChanged(false);
              this.canPipeline = false;
            }
        }
        this.lastStatusCode = localHttpResponse.getStatusLine().getStatusCode();
        if (this.lastStatusCode != 200)
        {
          this.callbacks.serverError(this.lastStatusCode);
          closeConnection();
        }
      }
      else
      {
        return;
      }
      this.connection.receiveResponseEntity(localHttpResponse);
      localHttpResponse.getEntity().consumeContent();
      this.callbacks.requestSent();
      if (GoogleAnalyticsTracker.getInstance().getDebug())
        Log.v("GoogleAnalyticsTracker", "HTTP Response Code: " + localHttpResponse.getStatusLine().getStatusCode());
    }
    while (this.canPipeline);
    closeConnection();
  }
}

/* Location:
 * Qualified Name:     com.google.android.apps.analytics.PipelinedRequester
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
