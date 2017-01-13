package app.test.testapp3;

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
    private T list;

    public JSONTest() {
    }

    public JSONTest(String result, String message, T list) {
        this.result = result;
        this.message = message;
        this.list = list;
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

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "JSONTest{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
//                ", total_block=" + total_block +
//                ", after_block=" + after_block +
//                ", current_block=" + current_block +
//                ", before_block=" + before_block +
//                ", begin_block=" + begin_block +
//                ", kwd='" + kwd + '\'' +
                ", list=" + list +
                '}';
    }

//    public int getTotal_block() {
//        return total_block;
//    }
//
//    public void setTotal_block(int total_block) {
//        this.total_block = total_block;
//    }
//
//    public int getAfter_block() {
//        return after_block;
//    }
//
//    public void setAfter_block(int after_block) {
//        this.after_block = after_block;
//    }
//
//    public int getCurrent_block() {
//        return current_block;
//    }
//
//    public void setCurrent_block(int current_block) {
//        this.current_block = current_block;
//    }
//
//    public int getBefore_block() {
//        return before_block;
//    }
//
//    public void setBefore_block(int before_block) {
//        this.before_block = before_block;
//    }
//
//    public int getBegin_block() {
//        return begin_block;
//    }
//
//    public void setBegin_block(int begin_block) {
//        this.begin_block = begin_block;
//    }
//
//    public String getKwd() {
//        return kwd;
//    }
//
//    public void setKwd(String kwd) {
//        this.kwd = kwd;
//    }
}
