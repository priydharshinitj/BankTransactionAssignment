package com.hcl.bankoperations;
import com.hcl.bankdetails.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;
class SortByDate implements Comparator<BankTransactions>{
	public int compare(BankTransactions a,BankTransactions b) {
		return a.getTransactiondate().compareTo(b.getTransactiondate());
	}
}
public class Main {
	public static void main(String[] args) {
		List<BankAccount> accountList=new ArrayList<BankAccount>();
		List<BankTransactions> transactionList=new ArrayList<BankTransactions>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Map<String,List<BankAccount>> map=new HashMap<String,List<BankAccount>>();
		Map<String,List<BankTransactions>> maptran=new HashMap<String,List<BankTransactions>>();
		try {
			// To read bankaccount.txt file and store the details in the map
			FileInputStream fs=new FileInputStream("bankaccount.txt");
			Scanner sc=new Scanner(fs);
			sc.nextLine();
			while(sc.hasNextLine()) {
				String[] account=sc.nextLine().split(",");
				BankAccount acc=new BankAccount(account[0],Integer.parseInt(account[1]),account[2],account[3],account[4],Integer.parseInt(account[5]));
				accountList.add(acc);
				for(Map.Entry<String,List<BankAccount>> map2:map.entrySet()){
		    		String name=map2.getKey().toString();
		    		if(name.equals(account[0])) {
		    			List<BankAccount> ac=map2.getValue();
		    			ac.add(acc);
		    			map.put(account[0], ac);
		    			break;
		    		}
				}
				List<BankAccount> aList=new ArrayList<BankAccount>();
				aList.add(acc);
				map.putIfAbsent(account[0], aList);
			}
			// To read banktransaction.txt file and store the details in the map
			FileInputStream fs1=new FileInputStream("banktransaction.txt");
			sc.close();
			sc=new Scanner(fs1);
			sc.nextLine();
			while(sc.hasNextLine()) {
				String[] tran=sc.nextLine().split(",");
				BankTransactions transaction=new BankTransactions(tran[0],sdf.parse(tran[1]),Integer.parseInt(tran[2]));
				transactionList.add(transaction);
				for(Map.Entry<String,List<BankTransactions>> map2:maptran.entrySet()){
		    		String cardno=map2.getKey().toString();
		    		if(cardno.equals(tran[0])) {
		    			List<BankTransactions> bt=map2.getValue();
		    			bt.add(transaction);
		    			maptran.put(tran[0], bt);
		    			break;
		    		}
				}
				List<BankTransactions> bList=new ArrayList<BankTransactions>();
				bList.add(transaction);
				maptran.putIfAbsent(tran[0],bList);
			}
			sc.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//To search transaction details by name and display details grouping by bank and then sort details based on transaction date
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name to search:");
		String name=sc.nextLine();
		List<BankTransactions> bt=new ArrayList<BankTransactions>();
		List<BankAccount> ac=new ArrayList<BankAccount>();
		ac=map.get(name);
		int sno=1;
		System.out.printf("%20s%20s%20s%20s%20s%20s%20s\n","S.NO","Name","Bank","Age","Gender","TransactionDate","TransactionAmount");
		for(int i=0;i<ac.size();i++) {
			int flag=0;
			bt=maptran.get(ac.get(i).getCardNumber());
			if(bt!=null) {
				Collections.sort(bt,new SortByDate());
				for(int j=0;j<bt.size();j++) {
					if(flag>0) {
						System.out.printf("%20s%20s%20s%20d%20s%20s%20s\n","","",ac.get(i).getBankName(),ac.get(i).getAge(),ac.get(i).getGender(),sdf.format(bt.get(j).getTransactiondate()),bt.get(j).getAmount());
					}
					else {
						System.out.printf("%20d%20s%20s%20d%20s%20s%20s\n",sno,ac.get(i).getName(),ac.get(i).getBankName(),ac.get(i).getAge(),ac.get(i).getGender(),sdf.format(bt.get(j).getTransactiondate()),bt.get(j).getAmount());
					}
					flag++;
				}
				sno++;
			}
		}	
	}
}
