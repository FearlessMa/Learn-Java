package com.study;
 

public class JavaDemo {
	public static void main(String [] arg) {
		Persons p1 = new Persons("1",10);
		Persons p2 = new Persons("2",10);
		Persons p3 = new Persons("3",10);
		p1.setCountry("333");
		p1.getInfo();
		p2.getInfo();
		Persons.setCountry("222");
		p3.getInfo(); 
		
		int Arr []= new int [] {1,2,3};
		
		for(int item:Arr) {
			System.out.println(item);
		}
		for(int i=0;i<Arr.length;i++) {
			System.out.println(Arr[i]);
		}
		System.out.println("***********");
		int arr1 [] = new int [] {1,2,3,4,5};
		ArrayUtil.printArray(arr1);
		ArrayUtil.reverseArr(arr1);
		ArrayUtil.printArray(arr1);
		Persons2 per1 = new Persons2();
		System.out.println(per1.getInfo());
		Persons2 perArr [] = new Persons2 [] {new Persons2(),new Persons2("aa",2)};
		Persons2 perArr1 [] = new Persons2 [3];
		for(Persons2 item : perArr1) {
			System.out.println(item);
		}
		for(Persons2 item : perArr) {
			System.out.println(item.getInfo());
		}
	}

}


class Persons2 {
    private String name;
    private int age;
    public Persons2(){
        this("无名氏",0);
    }
    public Persons2(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getInfo(){
        return "name:"+this.name+"、age:"+this.age;
    }
}


class ArrayUtil{
	public static void reverseArr(int arr []) {
		int len = arr.length-1;
		for(int i = 0 ; i <arr.length; i++) {
			if(i>len-i) {
				break ;
			}
			int temp = arr[i];
			arr[i] = arr[len-i];
			arr[len-i] =temp; 
		}
		
	}
	public static void printArray (int [] arr) {
		for(int item :arr) {
			System.out.print(item+"、");
		}
		System.out.println();
	}
}

class Persons {
	 private String name;
	 private int age;
	 
	 private static String country ;
	 
	 public Persons(String name, int age) {
		 this.name = name;
		 this.age = age;
		 country="111";
	 }
	 public String getInfo() {
		 System.out.println("name:"+this.name+"age:"+this.age+"country:"+this.country);
		 return "name:"+this.name+"age:"+this.age+"country:"+this.country;
	 }
	 static void setCountry(String c) {
		 country = c;
	 }
}