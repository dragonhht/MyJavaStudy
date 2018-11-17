package con.github.dragonhht.study;

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

/**
 * 学习代码.
 * User: huang
 * Date: 18-11-17
 */
public class StudyTest {

    private String url = "http://www.baidu.com";

    /**
     * 构建异步GET请求.
     */
    @Test
    public void testAsnycGet() throws InterruptedException {
        // 创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        // 构造Request
        final Request request = new Request.Builder()
                .url(url)
                .get() // GET 请求
                .build();
        // 回调
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                System.out.println("failure");
            }

            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("response body is: " + response.body().string());
            }
        });
        Thread.sleep(2000);
    }

    /**
     * 同步GET请求.
     */
    @Test
    public void testSyncGet() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = client.newCall(request);
        // 使用execute方法提交请求，但该方法会阻塞调用线程，建议使用子线程
        Response respon = call.execute();
        System.out.println("response body is:" + respon.body().string());
        /*new Thread(() -> {
            try {
                Response response = call.execute();
                System.out.println("response body is:" + response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });*/
    }

    /**
     * 异步POST请求.
     * @throws InterruptedException
     */
    @Test
    public void testAsyncPost() throws InterruptedException {
        MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
        String requestBody = "hello";
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(mediaType, requestBody))
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                System.out.println("onFailure");
            }
            @Override public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.protocol() + " " +response.code() + " " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    System.out.println(headers.name(i) + ":" + headers.value(i));
                }
                System.out.println("response body is: " + response.body().string());
            }
        });
        Thread.sleep(30000);
    }

}
