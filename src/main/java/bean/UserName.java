package bean;

//专门用来查找回复评论 用户名的
public class UserName {
    private String name;
    private String r_no;
    private String from_name;
    private String to_name;
    private String d_no;

    public void setName(String name){
        this.name=name;
    }
    public String getName()
    {
        return name;
    }

    public void setR_no(String r_no){
        this.r_no=r_no;
    }
    public String getR_no()
    {
        return r_no;
    }

    public void setFrom_name(String from_name){
        this.from_name=from_name;
    }
    public String getFrom_name()
    {
        return from_name;
    }

    public void setTo_name(String to_name){
        this.to_name=to_name;
    }
    public String getTo_name()
    {
        return to_name;
    }

    public void setD_no(String d_no){
        this.d_no=d_no;
    }
    public String getD_no()
    {
        return d_no;
    }


}
