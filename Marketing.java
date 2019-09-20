package LHW8day2;

import java.util.Objects;

public class Marketing {
String employeename;
String productname;
double salesamount;
public Marketing(String employeename, String productname, double salesamount) {
super();
this.employeename = employeename;
this.productname = productname;
this.salesamount = salesamount;
}
public String getEmployeename() {
return employeename;
}
public String getProductname() {
return productname;
}
public double getSalesamount() { return salesamount;
}
@Override
public String toString() {
return "[" + employeename + " , " + productname + " , " + salesamount + "]";
}
public boolean equals(Object ob) {
if (ob == null)
return false;
if (ob == this)
return true;
if (!(ob instanceof Marketing))
return false;
Marketing m = (Marketing) ob;
if (m.employeename.equals(this.employeename) && m.productname.equals(this.productname)
&& m.salesamount == this.salesamount)
return true;
else
return false;
}
public int hashCode() {
return Objects.hash(employeename, productname, salesamount);
}
}