package app.test.testapp3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static Button button;
    static TextView textView;
    static EditText editText;
    static EditText editText2;
    static EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FetchAsync().execute();
            }
        });
    }

    private class JSONTest2 extends JSONTest<List<ShopVo>> {
    }
    private class JSONTest3 extends JSONTest<Page> {
    }

    private class FetchAsync extends SafeAsyncTask<List<ShopVo>> {

        @Override
        public List<ShopVo> call() throws Exception {

            Gson gson = new GsonBuilder().create(); // gson 선언

//            HttpRequest httpRequest = HttpRequest.get("http://192.168.1.15:8088/modeal/shop/test", true, "page", 3); // get 방식
            HttpRequest httpRequest = HttpRequest.post("http://192.168.1.13:8088/modeal/shop/test"); // post 방식

            httpRequest.accept(HttpRequest.CONTENT_TYPE_JSON); // 받아 오는 데이터 타입 설정
            httpRequest.contentType(HttpRequest.CONTENT_TYPE_JSON); // 넘겨 주는 데이터 타입 설정

//            Page page = new Page();
//            page.setPage(Integer.parseInt(editText.getText().toString()));
//            page.setKeyword(editText2.getText().toString());
//            page.setFilterCheck(Integer.parseInt(editText3.getText().toString()));
//
//            String json2 = gson.toJson(page);
//            Log.d("!@!@", json2);
//
//            httpRequest.form(JSONTest3.class, json2); // post 방식

//            httpRequest.send("page=" + page.getPage());

//            Reader와 비슷하지만 살짝 다름
//            code(), ok()와 같은 메소드들은 첫 요청 이후 여러 번 재 호출해도 되지만
//            body() 메 소드는 한 번 호출 이후 재호출을 할 경우 IOException이 발생합니다.
//            String body = httpRequest.body();

            Reader reader = httpRequest.bufferedReader(); // url에서 데이터 가져오기
            JSONTest2 str = gson.fromJson(reader, JSONTest2.class); // 받아온 json 데이터 객체로 변경
            return str.getData();
        }

        @Override
        protected void onException(Exception e) throws RuntimeException {
            super.onException(e);
        }

        @Override
        protected void onSuccess(List<ShopVo> shopVos) throws Exception {
//            List<ShopVo> list = new ArrayList<ShopVo>(shopVos);
            String st = "";
            for (ShopVo shopVo : shopVos) {
                st += shopVo.getNo().toString() + '\n';
                ((TextView) MainActivity.textView).setText(st);
            }
        }
    }

    public class Page { // alt + insert
        private int page;
        private String keyword;
        private int filterCheck;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public int getFilterCheck() {
            return filterCheck;
        }

        public void setFilterCheck(int filterCheck) {
            this.filterCheck = filterCheck;
        }

        @Override
        public String toString() {
            return "Page{" +
                    "page=" + page +
                    ", keyword='" + keyword + '\'' +
                    ", filterCheck=" + filterCheck +
                    '}';
        }
    }
}
