package bean;

public class RandomID {
    public static String getCharAndNumr3(int length) {

        StringBuffer valSb = new StringBuffer();

        for (int i = 0; i < length; i++) {

            String charOrNum = Math.round(Math.random()) % 2 == 0 ? "char" : "num"; // 输出字母还是数字

            if ("char".equalsIgnoreCase(charOrNum)) {

                // 字符串

                int choice = Math.round(Math.random()) % 2 == 0 ? 65 : 97;  // 取得大写字母还是小写字母

                valSb.append((char) (choice + Math.round(Math.random()*25)));

            } else if ("num".equalsIgnoreCase(charOrNum)) {

                // 数字
                valSb.append(String.valueOf(Math.round(Math.random()*9)));

            }

        }

        return valSb.toString();

    }

}
