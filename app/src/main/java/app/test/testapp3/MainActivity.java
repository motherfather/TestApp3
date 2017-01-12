package app.test.testapp3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
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

        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
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

    private class FetchAsync extends SafeAsyncTask<List<ShopVo>> {

        @Override
        public List<ShopVo> call() throws Exception {
            Gson gson = new GsonBuilder().create();

            HttpRequest httpRequest = HttpRequest.post("http://192.168.1.15:8088/modeal/shop/test"); // post와 get 차이 궁금!!!

            httpRequest.accept(HttpRequest.CONTENT_TYPE_JSON);
            Reader reader = httpRequest.bufferedReader();

            JSONTest2 str = gson.fromJson(reader, JSONTest2.class);

            /* ---------------------------------------------------------- */

            httpRequest.contentType(HttpRequest.CONTENT_TYPE_JSON);
            Writer writer = httpRequest.writer();

            Page page = new Page();
            page.setPage(Integer.parseInt(editText.getText().toString()));
            page.setKeyword(editText2.getText().toString());
            page.setOption(Integer.parseInt(editText3.getText().toString()));

            String json2 = gson.toJson(page);

            return str.getList();
        }

        @Override
        protected void onException(Exception e) throws RuntimeException {
            super.onException(e);
        }

        @Override
        protected void onSuccess(List<ShopVo> shopVos) throws Exception {
            List<ShopVo> list = new ArrayList<ShopVo>(shopVos);
            String st = "";
            for (ShopVo shopVo : list) {
                st += shopVo.getName().toString() + '\n';
                ((TextView) MainActivity.textView).setText(st);
            }
        }

        /*
                @Override
                protected void onException(Exception e) throws RuntimeException {
                    // super.onException(e);
                    throw new RuntimeException(e);
                }

        @Override
        protected void onSuccess(List<ShopVo> list) throws Exception {
            JSONArray json = new JSONArray(list);
            Log.d("두근", json.toString());
            ((TextView) MainActivity.textView).setText(json.toString());
        }
        */
    }

    public class Page {
        private int page;
        private String keyword;
        private int option;

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

        public int getOption() {
            return option;
        }

        public void setOption(int option) {
            this.option = option;
        }

        @Override
        public String toString() {
            return "Page{" +
                    "page=" + page +
                    ", keyword='" + keyword + '\'' +
                    ", option=" + option +
                    '}';
        }
    }
}
