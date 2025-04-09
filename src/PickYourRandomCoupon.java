import java.util.*;

class Coupon{
    static final int KIND_MAX=3;
    static final int DIS_NUM=3;

    static final int COS =3;
    static final int FOOD = 2;
    static final int ELECT =1;

    static final int PICKED=4;
    static final int BAD =3;
    static final int SOSO =2;
    static final int GOOD=1;

    int kind;
    int dis;

    Coupon(){
        this(0,0);
    }
    Coupon(int kind, int dis){
        this.kind=kind;
        this.dis=dis;
    }
}
class Coupondeck{
    static final int MAX_NUM=20;
    Coupon[][] coupons = new Coupon[Coupon.KIND_MAX][MAX_NUM];
    Coupondeck(){
        for(int i=0;i<Coupon.KIND_MAX;i++){
            for(int j=0;j<MAX_NUM;j++){
                if(j==0){coupons[i][j]=new Coupon(i+1,1);}
                else if(j<=2){coupons[i][j]=new Coupon(i+1,3);}
                else{coupons[i][j]=new Coupon(i+1,2);}
            }
        }
    }
    Coupon pick(int choose, int oper){
        return shuffle(choose, oper);
    }
    Coupon shuffle(int choose, int oper){
        Coupon swp;
        int tmp=0;
        do{
            for(int i=0;i<coupons[choose].length;i++){
                tmp=(int)(Math.random()* coupons[0].length);
                swp=coupons[choose][tmp];
                coupons[choose][i]=coupons[choose][tmp];
                coupons[choose][tmp]=swp;
            }
        }while(coupons[choose][0].dis==Coupon.PICKED || (oper==1&&coupons[choose][0].dis== Coupon.BAD));
        return coupons[choose][0];
    }
}
public class PickYourRandomCoupon {
    public static void main(String[] args) {
        int oper=3; //3번의 기회
        int say=0; //입력값
        Coupon[] pick=new Coupon[3];
        Coupondeck Cd=new Coupondeck();
        Scanner in = new Scanner(System.in);
        System.out.println("도전? 만족? 세 번의 기회! 대박을 노려라!");
        do{
            System.out.println("도전하시겠습니까? 만족하십니까?(1. 도전 / 2. 만족)");
            say = in.nextInt();
            if(say==1){
                System.out.println("어떤 쿠폰을 원하세요?(1. 전자기기류 / 2. 식품류 / 3. 화장품류)");
                say = in.nextInt();
                pick[3-oper]=Cd.pick(say,oper);
                if (pick[3-oper].dis==Coupon.BAD){System.out.println("도전 실패!"); break;}
                else if (pick[3-oper].dis==Coupon.GOOD){ System.out.println("대박 성공!");  break;}
                else{ System.out.println("1000원 쿠폰 당첨"); }
                oper--;
            }
            else{break;}
        }while(oper>0);

        System.out.println(pick[0].dis+","+pick[1].dis+","+pick[2].dis);

    }
}