package p.g.p.service;



import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
 

import p.g.p.model.Shopping;
 


public class NaverShoppingService {
	private static String clientID = "fRAgrdQQv66rzySCi3kM";
	private static String clientSecret = "fVwZY5Dk1Y";
	// display ==> 몇개 출력
	// start==>몇번쨰부터 (item)
	public List<Shopping> searchShopping(String keyword, int display, int start) {
		List<Shopping> list = null;
		try {
			URL url;
			url = new URL(
					
					"https://openapi.naver.com/v1/search/" + "shop.xml?query=" + URLEncoder.encode(keyword, "UTF-8")
							+ (display != 0 ? "&display=" + display : "") + (start != 0 ? "&start=" + start : ""));

			URLConnection urlConn = url.openConnection();
			urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
			urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new InputStreamReader(urlConn.getInputStream()));
			// Test에서 했던 방식은 DOM방식이기때문에?
			// 그래서 이렇게 해도 된다?!??!??!?

			int eventType = parser.getEventType();
			Shopping b = null;
			while (eventType != XmlPullParser.END_DOCUMENT) {
				switch (eventType) {
				case XmlPullParser.END_DOCUMENT: // 문서의 끝
					break;
				case XmlPullParser.START_DOCUMENT:
					list = new ArrayList<Shopping>();
					break;
				case XmlPullParser.END_TAG: {
					String tag = parser.getName();
					if (tag.equals("item")) {
						list.add(b);
						b = null;
					}
				}
				case XmlPullParser.START_TAG: {
					String tag = parser.getName();
					switch (tag) {
					case "item":
						b = new Shopping();
						break;
					case "channel":
						if (b != null)
							b.setChannel(parser.nextText());
						break;
					case "display":
						if (b != null)
							b.setDisplay(parser.nextText());
						break;
					case "hprice":
						if (b != null)
							b.setHprice(parser.nextText());
						break;
					case "image":
						if (b != null)
							b.setImage(parser.nextText());
						break;
					case "lprice":
						if (b != null)
							b.setLprice(parser.nextText());
						break;
					case "link":
						if (b != null)
							b.setLink(parser.nextText());
						break;
					case "title":
						if (b != null)
							b.setTitle(parser.nextText());
						break;
					case "mallName":
						if (b != null)
							b.setMallName(parser.nextText());
						break;
					}

				}
				}
				eventType = parser.next();
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
