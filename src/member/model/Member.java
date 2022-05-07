package member.model;

public class Member {
   private String id;
   private String name;
   private String password;
   private int total_size;
   private int com_heat;
   private int com_clean;
   private int com_ev;
   private int com_es;
   private int com_maintain;
   private int com_insur;
   private int com_labor;
   private int com_water;
   private int com_ele ;
   

   public Member(String id, String name, String password, int total_size, int com_heat, int com_clean, int com_ev, int com_es,
         int com_maintain, int com_insur, int com_labor, int com_water, int com_ele) {

      this.id = id;
      this.name = name;
      this.password = password;
      this.total_size = total_size;
      this.com_heat = com_heat;
      this.com_clean = com_clean;
      this.com_ev = com_ev;
      this.com_es = com_es;
      this.com_maintain = com_maintain;
      this.com_insur = com_insur;
      this.com_labor = com_labor;
      this.com_water = com_water;
      this.com_ele = com_ele;
   }
   


   public String getId() {
      return id;
   }


   public void setId(String id) {
      this.id = id;
   }


   public String getName() {
      return name;
   }


   public void setName(String name) {
      this.name = name;
   }


   public String getPassword() {
      return password;
   }


   public void setPassword(String password) {
      this.password = password;
   }


   public int getTotal_size() {
      return total_size;
   }


   public void setTotal_size(int total_size) {
      this.total_size = total_size;
   }


   public int getCom_heat() {
      return com_heat;
   }


   public void setCom_heat(int com_heat) {
      this.com_heat = com_heat;
   }


   public int getCom_clean() {
      return com_clean;
   }


   public void setCom_clean(int com_clean) {
      this.com_clean = com_clean;
   }


   public int getCom_ev() {
      return com_ev;
   }


   public void setCom_ev(int com_ev) {
      this.com_ev = com_ev;
   }


   public int getCom_es() {
      return com_es;
   }


   public void setCom_es(int com_es) {
      this.com_es = com_es;
   }


   public int getCom_maintain() {
      return com_maintain;
   }


   public void setCom_maintain(int com_maintain) {
      this.com_maintain = com_maintain;
   }


   public int getCom_insur() {
      return com_insur;
   }


   public void setCom_insur(int com_insur) {
      this.com_insur = com_insur;
   }


   public int getCom_labor() {
      return com_labor;
   }


   public void setCom_labor(int com_labor) {
      this.com_labor = com_labor;
   }


   public int getCom_water() {
      return com_water;
   }


   public void setCom_water(int com_water) {
      this.com_water = com_water;
   }


   public int getCom_ele() {
      return com_ele;
   }


   public void setCom_ele(int com_ele) {
      this.com_ele = com_ele;
   }
   public boolean matchPassword(String pwd) {
      return password.equals(pwd);
   }
   public void changePassword(String newPwd) {
      this.password = newPwd;
   }

}