package com.spotify.android.paste.graphics;

public enum SpotifyIcon
{
  private int mDefaultSize;
  private String mUnicode;

  static
  {
    A = new SpotifyIcon("FILTER_16", 26, "", 16);
    B = new SpotifyIcon("FILTER_32", 27, "", 32);
    C = new SpotifyIcon("FLAG_16", 28, "", 16);
    D = new SpotifyIcon("FLAG_32", 29, "", 32);
    E = new SpotifyIcon("FOLLOW_16", 30, "", 16);
    F = new SpotifyIcon("FOLLOW_32", 31, "", 32);
    G = new SpotifyIcon("GEARS_16", 32, "", 16);
    H = new SpotifyIcon("GEARS_32", 33, "", 32);
    I = new SpotifyIcon("INBOX_16", 34, "", 16);
    J = new SpotifyIcon("INBOX_32", 35, "", 32);
    K = new SpotifyIcon("INFO_16", 36, "", 16);
    L = new SpotifyIcon("INFO_32", 37, "", 32);
    M = new SpotifyIcon("LOCKED_16", 38, "", 16);
    N = new SpotifyIcon("LOCKED_32", 39, "", 32);
    O = new SpotifyIcon("MESSAGES_16", 40, "", 16);
    P = new SpotifyIcon("MESSAGES_32", 41, "", 32);
    Q = new SpotifyIcon("MORE_16", 42, "", 16);
    R = new SpotifyIcon("MORE_32", 43, "", 32);
    S = new SpotifyIcon("NOTIFICATIONS_16", 44, "", 16);
    T = new SpotifyIcon("NOTIFICATIONS_32", 45, "", 32);
    U = new SpotifyIcon("PAUSE_16", 46, "", 16);
    V = new SpotifyIcon("PAUSE_32", 47, "", 32);
    W = new SpotifyIcon("PLAY_16", 48, "", 16);
    X = new SpotifyIcon("PLAY_32", 49, "", 32);
    Y = new SpotifyIcon("PLAYLIST_16", 50, "", 16);
    Z = new SpotifyIcon("PLAYLIST_32", 51, "", 32);
    aa = new SpotifyIcon("PLAYLIST_FOLDER_16", 52, "", 16);
    ab = new SpotifyIcon("PLAYLIST_FOLDER_32", 53, "", 32);
    ac = new SpotifyIcon("PLUS_16", 54, "", 16);
    ad = new SpotifyIcon("PLUS_32", 55, "", 32);
    ae = new SpotifyIcon("QUEUE_16", 56, "", 16);
    af = new SpotifyIcon("QUEUE_32", 57, "", 32);
    ag = new SpotifyIcon("RADIO_16", 58, "", 16);
    ah = new SpotifyIcon("RADIO_32", 59, "", 32);
    ai = new SpotifyIcon("REPEAT_16", 60, "", 16);
    aj = new SpotifyIcon("REPEAT_32", 61, "", 32);
    ak = new SpotifyIcon("SEARCH_16", 62, "", 16);
    al = new SpotifyIcon("SEARCH_32", 63, "", 32);
    am = new SpotifyIcon("SHARE_16", 64, "", 16);
    an = new SpotifyIcon("SHARE_32", 65, "", 32);
    ao = new SpotifyIcon("SHUFFLE_16", 66, "", 16);
    ap = new SpotifyIcon("SHUFFLE_32", 67, "", 32);
    aq = new SpotifyIcon("SKIP_BACK_16", 68, "", 16);
    ar = new SpotifyIcon("SKIP_BACK_32", 69, "", 32);
    as = new SpotifyIcon("SKIP_FORWARD_16", 70, "", 16);
    at = new SpotifyIcon("SKIP_FORWARD_32", 71, "", 32);
    au = new SpotifyIcon("STAR_16", 72, "", 16);
    av = new SpotifyIcon("STAR_32", 73, "", 32);
    aw = new SpotifyIcon("TAG_16", 74, "", 16);
    ax = new SpotifyIcon("TAG_32", 75, "", 32);
    ay = new SpotifyIcon("THUMBS_DOWN_16", 76, "", 16);
    az = new SpotifyIcon("THUMBS_DOWN_32", 77, "", 32);
    aA = new SpotifyIcon("THUMBS_UP_16", 78, "", 16);
    aB = new SpotifyIcon("THUMBS_UP_32", 79, "", 32);
    aC = new SpotifyIcon("TIME_16", 80, "", 16);
    aD = new SpotifyIcon("TIME_32", 81, "", 32);
    aE = new SpotifyIcon("TOPLIST_16", 82, "", 16);
    aF = new SpotifyIcon("TOPLIST_32", 83, "", 32);
    aG = new SpotifyIcon("TRACK_16", 84, "", 16);
    aH = new SpotifyIcon("TRACK_32", 85, "", 32);
    aI = new SpotifyIcon("TRENDING_16", 86, "", 16);
    aJ = new SpotifyIcon("TRENDING_32", 87, "", 32);
    aK = new SpotifyIcon("USER_16", 88, "", 16);
    aL = new SpotifyIcon("USER_32", 89, "", 32);
    aM = new SpotifyIcon("VOLUME_16", 90, "", 16);
    aN = new SpotifyIcon("VOLUME_32", 91, "", 32);
    aO = new SpotifyIcon("X_16", 92, "", 16);
    aP = new SpotifyIcon("X_32", 93, "", 32);
    aQ = new SpotifyIcon("ADD_TO_PLAYLIST_16", 94, "", 16);
    aR = new SpotifyIcon("ADD_TO_PLAYLIST_32", 95, "", 32);
    aS = new SpotifyIcon("DISCOVER_16", 96, "", 16);
    aT = new SpotifyIcon("DISCOVER_32", 97, "", 32);
    aU = new SpotifyIcon("GRID_VIEW_16", 98, "", 16);
    aV = new SpotifyIcon("GRID_VIEW_32", 99, "", 32);
    aW = new SpotifyIcon("LIST_VIEW_16", 100, "", 16);
    aX = new SpotifyIcon("LIST_VIEW_32", 101, "", 32);
    aY = new SpotifyIcon("ARROW_LEFT_16", 102, "", 16);
    aZ = new SpotifyIcon("ARROW_LEFT_32", 103, "", 32);
    ba = new SpotifyIcon("ARROW_RIGHT_16", 104, "", 16);
    bb = new SpotifyIcon("ARROW_RIGHT_32", 105, "", 32);
    bc = new SpotifyIcon("PLAY_NEXT_16", 106, "", 16);
    bd = new SpotifyIcon("PLAY_NEXT_32", 107, "", 32);
    be = new SpotifyIcon("PUBLIC_16", 108, "", 16);
    bf = new SpotifyIcon("PUBLIC_32", 109, "", 32);
    bg = new SpotifyIcon("REFRESH_16", 110, "", 16);
    bh = new SpotifyIcon("REFRESH_32", 111, "", 32);
    bi = new SpotifyIcon("RELEASED_16", 112, "", 16);
    bj = new SpotifyIcon("RELEASED_32", 113, "", 32);
    bk = new SpotifyIcon("REVIEWS_16", 114, "", 16);
    bl = new SpotifyIcon("REVIEWS_32", 115, "", 32);
    bm = new SpotifyIcon("SPOTIFY_CONNECT_16", 116, "", 16);
    bn = new SpotifyIcon("SPOTIFY_CONNECT_32", 117, "", 32);
    bo = new SpotifyIcon("TRENDING_METER_16", 118, "", 16);
    bp = new SpotifyIcon("TRENDING_METER_32", 119, "", 32);
    bq = new SpotifyIcon("EVENTS_16", 120, "", 16);
    br = new SpotifyIcon("EVENTS_32", 121, "", 32);
    bs = new SpotifyIcon("HOME_16", 122, "", 16);
    bt = new SpotifyIcon("HOME_32", 123, "", 32);
    bu = new SpotifyIcon("OFFLINE_SYNC_16", 124, "", 16);
    bv = new SpotifyIcon("OFFLINE_SYNC_32", 125, "", 32);
    bw = new SpotifyIcon("ADD_TO_QUEUE_16", 126, "", 16);
    bx = new SpotifyIcon("ADD_TO_QUEUE_32", 127, "", 32);
    by = new SpotifyIcon("ALBUM_CONTAINED_16", 128, "", 16);
    bz = new SpotifyIcon("ALBUM_CONTAINED_32", 129, "", 32);
    bA = new SpotifyIcon("X_24", 130, "", 24);
    bB = new SpotifyIcon("PLUS_24", 131, "", 24);
    bC = new SpotifyIcon("RADIO_24", 132, "", 24);
    bD = new SpotifyIcon("PLAY_24", 133, "", 24);
    bE = new SpotifyIcon("CHECK_24", 134, "", 24);
    bF = new SpotifyIcon("GRID_VIEW_24", 135, "", 24);
    bG = new SpotifyIcon("LIST_VIEW_24", 136, "", 24);
    bH = new SpotifyIcon("MORE_24", 137, "", 24);
    bI = new SpotifyIcon("NEW_VOLUME_16", 138, "", 16);
    bJ = new SpotifyIcon("NEW_VOLUME_24", 139, "", 24);
    bK = new SpotifyIcon("PAUSE_24", 140, "", 24);
    bL = new SpotifyIcon("REPEAT_24", 141, "", 24);
    bM = new SpotifyIcon("SHUFFLE_24", 142, "", 24);
    bN = new SpotifyIcon("SKIP_BACK_24", 143, "", 24);
    bO = new SpotifyIcon("SKIP_FORWARD_24", 144, "", 24);
    bP = new SpotifyIcon("SPOTIFY_CONNECT_24", 145, "", 24);
    bQ = new SpotifyIcon("THUMBS_DOWN_24", 146, "", 24);
    bR = new SpotifyIcon("THUMBS_UP_24", 147, "", 24);
    bS = new SpotifyIcon("VOLUME_24", 148, "", 24);
    bT = new SpotifyIcon("ARROW_UP_16", 149, "", 16);
    bU = new SpotifyIcon("ARROW_UP_32", 150, "", 32);
    bV = new SpotifyIcon("ARROW_DOWN_16", 151, "", 16);
    bW = new SpotifyIcon("ARROW_DOWN_32", 152, "", 32);
    bX = new SpotifyIcon("EDIT_16", 153, "", 16);
    bY = new SpotifyIcon("EDIT_32", 154, "", 32);
    bZ = new SpotifyIcon("ADDFOLLOW_16", 155, "", 16);
    ca = new SpotifyIcon("ADDFOLLOW_32", 156, "", 32);
    cb = new SpotifyIcon("EMAIL_16", 157, "", 16);
    cc = new SpotifyIcon("EMAIL_32", 158, "", 32);
    cd = new SpotifyIcon("FACEBOOK_16", 159, "", 16);
    ce = new SpotifyIcon("FACEBOOK_32", 160, "", 32);
    cf = new SpotifyIcon("SMS_16", 161, "", 16);
    cg = new SpotifyIcon("SMS_32", 162, "", 32);
    ch = new SpotifyIcon("TWITTER_16", 163, "", 16);
    ci = new SpotifyIcon("TWITTER_32", 164, "", 32);
    cj = new SpotifyIcon("VOLUME_OFF_16", 165, "", 16);
    ck = new SpotifyIcon("VOLUME_OFF_32", 166, "", 32);
    cl = new SpotifyIcon("WARNING_16", 167, "", 16);
    cm = new SpotifyIcon("WARNING_32", 168, "", 32);
    cn = new SpotifyIcon("LOCALFILE_16", 169, "", 16);
    co = new SpotifyIcon("LOCALFILE_32", 170, "", 32);
    cp = new SpotifyIcon("MENU_16", 171, "", 16);
    cq = new SpotifyIcon("MENU_32", 172, "", 32);
    cr = new SpotifyIcon("REPEATONCE_16", 173, "", 16);
    cs = new SpotifyIcon("REPEATONCE_24", 174, "", 24);
    ct = new SpotifyIcon("REPEATONCE_32", 175, "", 32);
    cu = new SpotifyIcon("VOLUME_ONEWAVE_16", 176, "", 16);
    cv = new SpotifyIcon("VOLUME_ONEWAVE_24", 177, "", 24);
    cw = new SpotifyIcon("VOLUME_ONEWAVE_32", 178, "", 32);
    cx = new SpotifyIcon("VOLUME_TWOWAVE_16", 179, "", 16);
    cy = new SpotifyIcon("VOLUME_TWOWAVE_24", 180, "", 24);
    cz = new SpotifyIcon("VOLUME_TWOWAVE_32", 181, "", 32);
    cA = new SpotifyIcon("LIBRARY_16", 182, "", 16);
    cB = new SpotifyIcon("LIBRARY_32", 183, "", 32);
    cC = new SpotifyIcon("APPFINDER_16", 184, "", 16);
    cD = new SpotifyIcon("APPFINDER_32", 185, "", 32);
    cE = new SpotifyIcon("WHATSAPP_16", 186, "", 16);
    cF = new SpotifyIcon("WHATSAPP_32", 187, "", 32);
    cG = new SpotifyIcon("DEVICES_16", 188, "", 16);
    cH = new SpotifyIcon("DEVICES_32", 189, "", 32);
    cI = new SpotifyIcon("SHARE_ANDROID_16", 190, "", 16);
    cJ = new SpotifyIcon("SHARE_ANDROID_32", 191, "", 32);
    cK = new SpotifyIcon("MORE_ANDROID_16", 192, "", 16);
    cL = new SpotifyIcon("MORE_ANDROID_24", 193, "", 24);
    cM = new SpotifyIcon("MORE_ANDROID_32", 194, "", 32);
    cN = new SpotifyIcon("OFFLINE_16", 195, "", 16);
    cO = new SpotifyIcon("OFFLINE_32", 196, "", 32);
    cP = new SpotifyIcon("NEWRADIO_16", 197, "", 16);
    cQ = new SpotifyIcon("NEWRADIO_32", 198, "", 32);
    cR = new SpotifyIcon("SORT_16", 199, "", 16);
    cS = new SpotifyIcon("SORT_32", 200, "", 32);
    cT = new SpotifyIcon("SORTDOWN_16", 201, "", 16);
    cU = new SpotifyIcon("SORTDOWN_32", 202, "", 32);
    cV = new SpotifyIcon("SORTUP_16", 203, "", 16);
    cW = new SpotifyIcon("SORTUP_32", 204, "", 32);
    cX = new SpotifyIcon("ADDSUGGESTEDSONG_16", 205, "", 16);
    cY = new SpotifyIcon("ADDSUGGESTEDSONG_32", 206, "", 32);
    SpotifyIcon[] arrayOfSpotifyIcon = new SpotifyIcon['Ï'];
    arrayOfSpotifyIcon[0] = a;
    arrayOfSpotifyIcon[1] = b;
    arrayOfSpotifyIcon[2] = c;
    arrayOfSpotifyIcon[3] = d;
    arrayOfSpotifyIcon[4] = e;
    arrayOfSpotifyIcon[5] = f;
    arrayOfSpotifyIcon[6] = g;
    arrayOfSpotifyIcon[7] = h;
    arrayOfSpotifyIcon[8] = i;
    arrayOfSpotifyIcon[9] = j;
    arrayOfSpotifyIcon[10] = k;
    arrayOfSpotifyIcon[11] = l;
    arrayOfSpotifyIcon[12] = m;
    arrayOfSpotifyIcon[13] = n;
    arrayOfSpotifyIcon[14] = o;
    arrayOfSpotifyIcon[15] = p;
    arrayOfSpotifyIcon[16] = q;
    arrayOfSpotifyIcon[17] = r;
    arrayOfSpotifyIcon[18] = s;
    arrayOfSpotifyIcon[19] = t;
    arrayOfSpotifyIcon[20] = u;
    arrayOfSpotifyIcon[21] = v;
    arrayOfSpotifyIcon[22] = w;
    arrayOfSpotifyIcon[23] = x;
    arrayOfSpotifyIcon[24] = y;
    arrayOfSpotifyIcon[25] = z;
    arrayOfSpotifyIcon[26] = A;
    arrayOfSpotifyIcon[27] = B;
    arrayOfSpotifyIcon[28] = C;
    arrayOfSpotifyIcon[29] = D;
    arrayOfSpotifyIcon[30] = E;
    arrayOfSpotifyIcon[31] = F;
    arrayOfSpotifyIcon[32] = G;
    arrayOfSpotifyIcon[33] = H;
    arrayOfSpotifyIcon[34] = I;
    arrayOfSpotifyIcon[35] = J;
    arrayOfSpotifyIcon[36] = K;
    arrayOfSpotifyIcon[37] = L;
    arrayOfSpotifyIcon[38] = M;
    arrayOfSpotifyIcon[39] = N;
    arrayOfSpotifyIcon[40] = O;
    arrayOfSpotifyIcon[41] = P;
    arrayOfSpotifyIcon[42] = Q;
    arrayOfSpotifyIcon[43] = R;
    arrayOfSpotifyIcon[44] = S;
    arrayOfSpotifyIcon[45] = T;
    arrayOfSpotifyIcon[46] = U;
    arrayOfSpotifyIcon[47] = V;
    arrayOfSpotifyIcon[48] = W;
    arrayOfSpotifyIcon[49] = X;
    arrayOfSpotifyIcon[50] = Y;
    arrayOfSpotifyIcon[51] = Z;
    arrayOfSpotifyIcon[52] = aa;
    arrayOfSpotifyIcon[53] = ab;
    arrayOfSpotifyIcon[54] = ac;
    arrayOfSpotifyIcon[55] = ad;
    arrayOfSpotifyIcon[56] = ae;
    arrayOfSpotifyIcon[57] = af;
    arrayOfSpotifyIcon[58] = ag;
    arrayOfSpotifyIcon[59] = ah;
    arrayOfSpotifyIcon[60] = ai;
    arrayOfSpotifyIcon[61] = aj;
    arrayOfSpotifyIcon[62] = ak;
    arrayOfSpotifyIcon[63] = al;
    arrayOfSpotifyIcon[64] = am;
    arrayOfSpotifyIcon[65] = an;
    arrayOfSpotifyIcon[66] = ao;
    arrayOfSpotifyIcon[67] = ap;
    arrayOfSpotifyIcon[68] = aq;
    arrayOfSpotifyIcon[69] = ar;
    arrayOfSpotifyIcon[70] = as;
    arrayOfSpotifyIcon[71] = at;
    arrayOfSpotifyIcon[72] = au;
    arrayOfSpotifyIcon[73] = av;
    arrayOfSpotifyIcon[74] = aw;
    arrayOfSpotifyIcon[75] = ax;
    arrayOfSpotifyIcon[76] = ay;
    arrayOfSpotifyIcon[77] = az;
    arrayOfSpotifyIcon[78] = aA;
    arrayOfSpotifyIcon[79] = aB;
    arrayOfSpotifyIcon[80] = aC;
    arrayOfSpotifyIcon[81] = aD;
    arrayOfSpotifyIcon[82] = aE;
    arrayOfSpotifyIcon[83] = aF;
    arrayOfSpotifyIcon[84] = aG;
    arrayOfSpotifyIcon[85] = aH;
    arrayOfSpotifyIcon[86] = aI;
    arrayOfSpotifyIcon[87] = aJ;
    arrayOfSpotifyIcon[88] = aK;
    arrayOfSpotifyIcon[89] = aL;
    arrayOfSpotifyIcon[90] = aM;
    arrayOfSpotifyIcon[91] = aN;
    arrayOfSpotifyIcon[92] = aO;
    arrayOfSpotifyIcon[93] = aP;
    arrayOfSpotifyIcon[94] = aQ;
    arrayOfSpotifyIcon[95] = aR;
    arrayOfSpotifyIcon[96] = aS;
    arrayOfSpotifyIcon[97] = aT;
    arrayOfSpotifyIcon[98] = aU;
    arrayOfSpotifyIcon[99] = aV;
    arrayOfSpotifyIcon[100] = aW;
    arrayOfSpotifyIcon[101] = aX;
    arrayOfSpotifyIcon[102] = aY;
    arrayOfSpotifyIcon[103] = aZ;
    arrayOfSpotifyIcon[104] = ba;
    arrayOfSpotifyIcon[105] = bb;
    arrayOfSpotifyIcon[106] = bc;
    arrayOfSpotifyIcon[107] = bd;
    arrayOfSpotifyIcon[108] = be;
    arrayOfSpotifyIcon[109] = bf;
    arrayOfSpotifyIcon[110] = bg;
    arrayOfSpotifyIcon[111] = bh;
    arrayOfSpotifyIcon[112] = bi;
    arrayOfSpotifyIcon[113] = bj;
    arrayOfSpotifyIcon[114] = bk;
    arrayOfSpotifyIcon[115] = bl;
    arrayOfSpotifyIcon[116] = bm;
    arrayOfSpotifyIcon[117] = bn;
    arrayOfSpotifyIcon[118] = bo;
    arrayOfSpotifyIcon[119] = bp;
    arrayOfSpotifyIcon[120] = bq;
    arrayOfSpotifyIcon[121] = br;
    arrayOfSpotifyIcon[122] = bs;
    arrayOfSpotifyIcon[123] = bt;
    arrayOfSpotifyIcon[124] = bu;
    arrayOfSpotifyIcon[125] = bv;
    arrayOfSpotifyIcon[126] = bw;
    arrayOfSpotifyIcon[127] = bx;
    arrayOfSpotifyIcon[''] = by;
    arrayOfSpotifyIcon[''] = bz;
    arrayOfSpotifyIcon[''] = bA;
    arrayOfSpotifyIcon[''] = bB;
    arrayOfSpotifyIcon[''] = bC;
    arrayOfSpotifyIcon[''] = bD;
    arrayOfSpotifyIcon[''] = bE;
    arrayOfSpotifyIcon[''] = bF;
    arrayOfSpotifyIcon[''] = bG;
    arrayOfSpotifyIcon[''] = bH;
    arrayOfSpotifyIcon[''] = bI;
    arrayOfSpotifyIcon[''] = bJ;
    arrayOfSpotifyIcon[''] = bK;
    arrayOfSpotifyIcon[''] = bL;
    arrayOfSpotifyIcon[''] = bM;
    arrayOfSpotifyIcon[''] = bN;
    arrayOfSpotifyIcon[''] = bO;
    arrayOfSpotifyIcon[''] = bP;
    arrayOfSpotifyIcon[''] = bQ;
    arrayOfSpotifyIcon[''] = bR;
    arrayOfSpotifyIcon[''] = bS;
    arrayOfSpotifyIcon[''] = bT;
    arrayOfSpotifyIcon[''] = bU;
    arrayOfSpotifyIcon[''] = bV;
    arrayOfSpotifyIcon[''] = bW;
    arrayOfSpotifyIcon[''] = bX;
    arrayOfSpotifyIcon[''] = bY;
    arrayOfSpotifyIcon[''] = bZ;
    arrayOfSpotifyIcon[''] = ca;
    arrayOfSpotifyIcon[''] = cb;
    arrayOfSpotifyIcon[''] = cc;
    arrayOfSpotifyIcon[''] = cd;
    arrayOfSpotifyIcon[' '] = ce;
    arrayOfSpotifyIcon['¡'] = cf;
    arrayOfSpotifyIcon['¢'] = cg;
    arrayOfSpotifyIcon['£'] = ch;
    arrayOfSpotifyIcon['¤'] = ci;
    arrayOfSpotifyIcon['¥'] = cj;
    arrayOfSpotifyIcon['¦'] = ck;
    arrayOfSpotifyIcon['§'] = cl;
    arrayOfSpotifyIcon['¨'] = cm;
    arrayOfSpotifyIcon['©'] = cn;
    arrayOfSpotifyIcon['ª'] = co;
    arrayOfSpotifyIcon['«'] = cp;
    arrayOfSpotifyIcon['¬'] = cq;
    arrayOfSpotifyIcon['­'] = cr;
    arrayOfSpotifyIcon['®'] = cs;
    arrayOfSpotifyIcon['¯'] = ct;
    arrayOfSpotifyIcon['°'] = cu;
    arrayOfSpotifyIcon['±'] = cv;
    arrayOfSpotifyIcon['²'] = cw;
    arrayOfSpotifyIcon['³'] = cx;
    arrayOfSpotifyIcon['´'] = cy;
    arrayOfSpotifyIcon['µ'] = cz;
    arrayOfSpotifyIcon['¶'] = cA;
    arrayOfSpotifyIcon['·'] = cB;
    arrayOfSpotifyIcon['¸'] = cC;
    arrayOfSpotifyIcon['¹'] = cD;
    arrayOfSpotifyIcon['º'] = cE;
    arrayOfSpotifyIcon['»'] = cF;
    arrayOfSpotifyIcon['¼'] = cG;
    arrayOfSpotifyIcon['½'] = cH;
    arrayOfSpotifyIcon['¾'] = cI;
    arrayOfSpotifyIcon['¿'] = cJ;
    arrayOfSpotifyIcon['À'] = cK;
    arrayOfSpotifyIcon['Á'] = cL;
    arrayOfSpotifyIcon['Â'] = cM;
    arrayOfSpotifyIcon['Ã'] = cN;
    arrayOfSpotifyIcon['Ä'] = cO;
    arrayOfSpotifyIcon['Å'] = cP;
    arrayOfSpotifyIcon['Æ'] = cQ;
    arrayOfSpotifyIcon['Ç'] = cR;
    arrayOfSpotifyIcon['È'] = cS;
    arrayOfSpotifyIcon['É'] = cT;
    arrayOfSpotifyIcon['Ê'] = cU;
    arrayOfSpotifyIcon['Ë'] = cV;
    arrayOfSpotifyIcon['Ì'] = cW;
    arrayOfSpotifyIcon['Í'] = cX;
    arrayOfSpotifyIcon['Î'] = cY;
  }

  private SpotifyIcon(String paramString, int paramInt)
  {
    this.mUnicode = paramString;
    this.mDefaultSize = paramInt;
  }

  public final int a()
  {
    return this.mDefaultSize;
  }

  public final String toString()
  {
    return this.mUnicode;
  }
}

/* Location:
 * Qualified Name:     com.spotify.android.paste.graphics.SpotifyIcon
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
