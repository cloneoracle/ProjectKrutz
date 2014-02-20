from scrapy.contrib.spiders import CrawlSpider
from scrapy.selector import Selector
from apkSpider.items import ApkItem
from scrapy.http import Request
from play import parse_google

class TeamApkSpider(CrawlSpider):
    name = "fdroid"
    allowed_domains = ["f-droid.org", "play.google.com"]
    start_urls = ["https://f-droid.org/repository/browse/"]

    # Parses the F-Droid "Browse" page and subsequent pages
    def parse(self, response):
        sel = Selector(response)
        apk_page_urls = sel.xpath('//a[descendant::div[@id="appheader"]]/@href').extract()

        for url in apk_page_urls:
            yield Request(url, callback=self.parse_page)

        next_page = sel.xpath('//a[text()[contains(., "next")]]/@href').extract()
        
        yield Request(next_page[0])

    # Parses pages for individual APK files
    def parse_page(self, response):
        sel = Selector(response)
        download_url = sel.xpath('//a[contains(@href, ".apk") and text()[contains(., "download apk")]]/@href').extract()
        app_id = response.url[response.url.find('id=') + 3:]
        google_play_url = 'https://play.google.com/store/apps/details?id=' + app_id
        
        if download_url:
            item = ApkItem()
            item['file_urls'] = [download_url[0]]
            yield item

            yield Request(google_play_url, meta={'download_url': response.url}, callback=parse_google)