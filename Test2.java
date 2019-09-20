package LHW8day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Test2 {
public static void main(String[] args) {
List<Marketing> market = new ArrayList<>();
// Adding elements:
market.add(new Marketing("Resty", "Samsung", 200.0));
market.add(new Marketing("Adam", "Itel", 7000.6));
market.add(new Marketing("Morren", "Apple", 2000.0));
market.add(new Marketing("Sherry", "Tehno", 400.98));
market.add(new Marketing("Resty", "Samsung", 200.0));
// printing elements:
System.out.println("Added objects to the Marketing :");
System.out.println(market.toString());
// removing sherry from the List
market.remove(new Marketing("Sherry", "Tehno", 400.98));
// printing new list after removing sherry:
System.out.println("\nNew list after removing sherry");
System.out.println(market.toString());
// printing the size of the list
System.out.println("\n Size of the list is :" + market.size());
Comparator<Marketing> com = new NameComparator();
// sorting
Collections.sort(market, com);
// printing sorted elements:
System.out.println("\n Sorted List using salesamount field");
System.out.println(market.toString());
Marketing m1 = new Marketing("Ken", "Huawei", 700.0);
Marketing m2 = new Marketing("Ken", "Huawei", 700.0);
Marketing m3 = new Marketing("Ruth", "Huawei", 700.0);
System.out.println("\n m1 compare m2 Result: " + com.compare(m1, m2)); // result = 0
System.out.println("\n m1 equals m2 Result: " + m1.equals(m2));// result should be true
System.out.println("\n m2 compare m3 Result: " + com.compare(m2, m3)); // employee names are Not equal
System.out.println("\n m2 equals m3 Result: " + m2.equals(m3));// result= false System.out.print("\nlistMoreThan1000");
System.out.print(listMoreThan1000(market).toString());
}
public static List<Marketing> listMoreThan1000(List<Marketing> list) {
Collections.sort(list, (e1, e2) -> {
if (e1.getEmployeename().compareTo(e2.getEmployeename()) != 0) {
return e1.getEmployeename().compareTo(e2.getEmployeename());
} else if (Double.compare(e1.getSalesamount(), e2.getSalesamount()) != 0) {
return Double.compare(e1.getSalesamount(), e2.getSalesamount());
} else
return e1.getProductname().compareTo(e2.getProductname());
});
list.removeIf(a -> a.salesamount < 1000);
return list;
}
}
class NameComparator implements Comparator<Marketing> {
@Override
public int compare(Marketing m1, Marketing m2) {
double amount1 = m1.getSalesamount();
double amount2 = m2.getSalesamount();
String employee1 = m1.getEmployeename();
String employee2 = m2.getEmployeename();
String product1 = m1.getProductname();
String product2 = m2.getProductname();
if (Double.compare(amount1, amount2) != 0) {
return Double.compare(amount1, amount2);
} else if (employee1.compareTo(employee2) != 0) {
return employee1.compareTo(employee2);
} else
return product1.compareTo(product2);
}
}