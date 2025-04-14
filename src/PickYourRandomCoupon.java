import java.util.*;

class Coupon{
    static final int COS =3;
    static final int FOOD = 2;
    static final int ELECT =1;

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
class Coupondeck{//정적 클래스 - 싱글톤으로 작성
    static final int MAX_NUM=20;
    static final int MAX_KIND=3;

    static final int GOOD_NUM=10;
    static final int BAD_NUM=2;

    Coupon[][] coupons = new Coupon[MAX_KIND][MAX_NUM];
    Coupondeck(){
        for(int i=1;i<=MAX_KIND;i++){
            for(int j=0;j<MAX_NUM;j++){
                if(j<GOOD_NUM){coupons[i-1][j]=new Coupon(Coupon.ELECT,Coupon.GOOD);}
                else if(j<BAD_NUM+GOOD_NUM){coupons[i-1][j]=new Coupon(Coupon.FOOD,Coupon.BAD);}
                else{coupons[i-1][j]=new Coupon(Coupon.COS,Coupon.SOSO);}
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
            for(int i=0;i<coupons[choose-1].length;i++){
                tmp=(int)(Math.random()* coupons[0].length);
                swp=coupons[choose-1][tmp];
                coupons[choose-1][i]=coupons[choose-1][tmp];
                coupons[choose-1][tmp]=swp;
            }
        }while(coupons[choose-1][0].dis==Coupon.BAD);
        return coupons[choose-1][0];
    }
}
public class PickYourRandomCoupon {
    public static void main(String[] args) {//게임플레이 클래스로 묶어보기
        int oper=3; //3번의 기회
        int say=0; //입력값
        Coupon[] pick=new Coupon[3];
        Coupondeck Cd=new Coupondeck();
        Scanner in = new Scanner(System.in);
        String[] kinds={"","전자기기류","식품류","화장품류"};

        System.out.println("도전? 만족? 세 번의 기회! 대박을 노려라!");
        do{
            System.out.println("도전하시겠습니까? 만족하십니까?(1. 도전 / 2. 만족)");
            say = in.nextInt();
            if(say==1){
                System.out.println("어떤 쿠폰을 원하세요?(1. 전자기기류 / 2. 식품류 / 3. 화장품류)");
                say = in.nextInt();
                pick[3-oper]=Cd.pick(say,oper);
                if (pick[3-oper].dis==Coupon.BAD){
                    System.out.println("꽝 쿠폰이 나왔다!");
                    Arrays.fill(pick, 0, 3, new Coupon()); // (0,0)객체로 배열 채움
                    break;
                }
                else if (pick[3-oper].dis==Coupon.GOOD){
                    System.out.println("대박 성공!");
                    break;
                }
                else{
                    System.out.println("1000원 쿠폰 당첨");
                    if(oper==1){Arrays.fill(pick, 0, 3, new Coupon());}
                }
                oper--;
            }
            else{break;}
        }while(oper>0);

        System.out.println("*******************");
        System.out.println(pick[0].dis+","+pick[1].dis+","+pick[2].dis);
        for(int i=0; i<3; i++){//0으로 초기화 한건 잘 나오는데.. pick[i].kind이 부분에서 문제가 많은 듯...
           if(pick[i].dis==Coupon.SOSO){
               if(pick[i].kind==Coupon.ELECT)System.out.print(kinds[pick[i].kind]+"1000원 쿠폰 당첨. ");
           }
            else if(pick[i].dis==Coupon.GOOD){
                System.out.print(kinds[pick[i].kind]+" 60% 할인쿠폰 당첨! 축하합니다!!");
                break;
            }
           else if(pick[i].dis==0){
               System.out.print("아쉽습니다... 쿠폰이 전부 사라졌어요..");
               break;
           }
        }

    }
}