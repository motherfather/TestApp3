package app.test.testapp3;

import static android.R.id.list;

/**
 * Created by BIT on 2017-01-12.
 */

public abstract class JSONTest<T> {

    private String result;
    private String message;
//    필요로 하는 값만 쓰면 그 값만 받아옴
//    private int total_block;
//    private int after_block;
//    private int current_block;
//    private int before_block;
//    private int begin_block;
//    private String kwd;kwd
    private T data;

    public JSONTest() {
    }

    public JSONTest(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JSONTest{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", list=" + list +
                '}';
    }
}
