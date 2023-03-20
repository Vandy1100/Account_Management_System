package account_management_system;

import java.lang.reflect.Array;
import java.util.*;

interface AccountManagement{

    void input();
    void output();

}
class GetAccount implements AccountManagement{
    int id;
    String ownerName;
    double balance;
    GetAccount(){
        id=0;
        ownerName=null;
        balance=0;
    }

    public GetAccount(int id, String ownerName, double balance) {
        this.id = id;
        this.ownerName = ownerName;
        this.balance = balance;
    }
    public  int getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }
    public int getBL(){
        return (int)balance;
    }
    @Override
    public void input() {
        Scanner sc= new Scanner(System.in);
        System.out.print("==> Input Id :");
        id= sc.nextInt();
        System.out.print("==> Input Owner Name :");
        sc.nextLine();
        ownerName= sc.nextLine();
        System.out.print("==> Input balance :");
        balance= sc.nextDouble();
    }

    @Override
    public void output() {
        System.out.println(getId() + "\t" + getOwnerName() + "\t\t\t" + getBalance());
    }

}
class DescId implements Comparator<GetAccount> {


    // Method
    // Sorting in Descending order of Id

    public  int compare(GetAccount a, GetAccount b)
    {
        return b.id-a.id;
    }
}
class SortByBalance implements Comparator<GetAccount> {
    // Method
    // Sorting in Descending order of Balance
    public int compare(GetAccount a, GetAccount b)
    {
        return b.getBL() - a.getBL();
    }
}

public class Account {


    public static void main(String[] args) {
        GetAccount account[] = new GetAccount[50];
        Scanner sc= new Scanner(System.in);
        ArrayList<GetAccount> list = new ArrayList();
        int n=0,i,op=0;
        do{
            System.out.println("=======Manu=======");
            System.out.println("==> 1. Add Account.");
            System.out.println("==> 2. Edit Account.");
            System.out.println("==> 3. Remove Account.");
            System.out.println("==> 4. Show Account Information.");
            System.out.println("==> 5. Sort Order.");
            System.out.println("==> 6. Exit");
            System.out.println("===============================");
            System.out.print("Please Choose Option (1-6) :");
            op=sc.nextInt();
            switch (op){
                case 1:{
                    System.out.println("==> 1. Add Account.");
                    System.out.print("==> Input Size of Account :");
                    n=sc.nextInt();
                    for(i=0;i<n;i++){
                        account[i]= new GetAccount();
                        account[i].input();
                        list.add(account[i]);
                    }
                }break;
                case 2:{
                    boolean edit=false;
                    System.out.println("==> 2. Edit Account.");
                    System.out.print("==> Input Id For Edit :");
                    int e_id=sc.nextInt();
                    for(i=0;i<list.size();i++){
                        if(e_id==list.get(i).getId()){
                            System.out.println("Id\tO_Name\tBalance");
                            account[i].output();
                            System.out.println("===========Update Account========");
                            account[i].input();
                            list.set(i,account[i]);
                            System.out.println("Edit Successful...");
                            edit=true;
                        }
                    }
                    if(edit==false){
                        System.out.println("Edit Not Successful...");
                    }
                }break;
                case 3:{
                    boolean delete=false;
                    System.out.println("==> 3. Delete Account.");
                    System.out.print("==> Input Id For Delete :");
                    int d_id=sc.nextInt();
                    for(i=0;i<list.size();i++){
                        if(d_id==list.get(i).getId()){
                            list.remove(i);
                            System.out.println("Delete Successful....");
                            delete=true;
                        }
                    }
                    if(delete==false){
                        System.out.println("Delete Fail...");
                    }
                }break;
                case 4:{
                    System.out.println("==> 4. Show Account.");
                    System.out.println("Id\tOwnerName\tBalance");
                    for(i=0;i<list.size();i++){
                        list.get(i).output();
                    }

                }break;
                case 5:{
                 int order=0;
                 do {
                     System.out.println("====Sort Order====");
                     System.out.println("==> 1.Ascending Order (by acc_id).");
                     System.out.println("==> 2.Descending Order (by acc_id).");
                     System.out.println("==> 3.Descending Order (by balance).");
                     System.out.println("==> 4.Exit");
                     System.out.println("=========================");
                     System.out.print("Please Choose Option (1-4) :");
                     order=sc.nextInt();
                     switch (order){
                         case 1:{
                             System.out.println("==> 1.Ascending Order (by acc_id).");
                             Collections.sort(list, Comparator.comparing(GetAccount::getId));
                             System.out.println("Sort Successful....");
                         }break;
                         case 2:{
                             System.out.println("==> 2.Descending Order (by acc_id).");
                             Collections.sort(list,new DescId());
                             System.out.println("Sort Successful....");
                         }break;
                         case 3:{
                             System.out.println("==> 2.Descending Order (by acc_id).");
                             Collections.sort(list, new SortByBalance());
                             System.out.println("Sort Successful....");
                         }break;
                     }
                 }while (order!=4);

                }break;

            }
        }while(op!=6);
    }
}
