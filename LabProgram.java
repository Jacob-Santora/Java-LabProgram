import java.util.Scanner;

public class LabProgram {
   
   // Calculate AGI and repair any negative values
   public static int calcAGI(int wages, int interest, int unemployment) {
   int agi;
   if(wages < 0)
      wages = Math.abs(wages);
   if(interest < 0)
      interest = Math.abs(interest);
   if(unemployment < 0)
      unemployment = Math.abs(unemployment);
      agi = wages + interest + unemployment;
      return agi;
   }

// Calculate deduction depending on single, dependent or married
   public static int getDeduction(int status) {
      int deduction;
   if (status == 0 || status == 5 )
      deduction = 6000;
   else if(status == 1)
      deduction = 12000;
   else
      deduction = 24000;
      return deduction;
   }

// Calculate taxable but not allow negative results
   public static int calcTaxable(int agi, int deduction) {
   int taxableAmount = agi - deduction;
   if(taxableAmount < 0)
      taxableAmount = 0;
      return taxableAmount;
   }

// Calculate tax for single or dependent
   public static int calcTax(int status, int taxable) {
/* Complete the method and update the return statement */
   float taxAmount = 0;
//calculate tax amount for singles and dependents
   if(status == 0 || status == 1)
   {
   if(taxable >= 0 && taxable <= 10000)
      taxAmount = (float)((taxable * 10.0) / 100.0);
   else if(taxable >= 10001 && taxable <= 40000)
   {
   int amt = taxable - 10000;
      taxAmount = (float)(1000 + ((amt * 12.0) / 100.0));
   }
      else if(taxable >= 40001 && taxable <= 85000)
   {
      int amt = taxable - 40000;
      taxAmount = (float)(4600 + ((amt * 22.0) / 100.0));
   }
   else
   {
      int amt = taxable - 85000;
      taxAmount = (float)(14500 + ((amt * 24.0) / 100.0));
   }
}
   else
   {
      if(taxable >= 0 && taxable <= 20000)
      taxAmount = (float)((taxable * 10.0) / 100.0);
      else if(taxable >= 20001 && taxable <= 80000)
   {
      int amt = taxable - 20000;
      taxAmount = (float)(2000 + ((amt * 12.0) / 100.0));
   }
   else
   {
      int amt = taxable - 80000;
      taxAmount = (float)(9200 + ((amt * 22.0) / 100.0));
   }

   }
      int tax = Math.round(taxAmount);
      return tax;
   }

public static int calcTaxDue(int tax, int withheld) {
      if(withheld < 0)
      withheld = 0;
      int due = tax - withheld;
      return due;
   }

      public static void main(String [] args) {
      Scanner scan = new Scanner(System.in);
      int wages = 0;
      int interest = 0;
      int unemployment = 0;
      int status = -1;
      int withheld = 0;
      int agi;
      int deduction;
      int taxableIncome;
      int federalTax;
      int due;

      // Step #1: Input information
      wages = scan.nextInt();
      interest = scan.nextInt();
      unemployment = scan.nextInt();
      status = scan.nextInt();
      withheld = scan.nextInt();
      
        // Step #2: Calculate AGI
     agi = calcAGI(wages, interest, unemployment);
      System.out.printf("AGI: $%,d\n", agi);

      // Step #3: Calculate deduction
      deduction = getDeduction(status);
      System.out.printf("Deduction: $%,d\n", deduction);

      // Step #4: Calculate taxable income
      taxableIncome = calcTaxable(agi, deduction);
      System.out.printf("Taxable income: $%,d\n", taxableIncome);

      // Step #5: Calculate federal tax
      federalTax = calcTax(status, taxableIncome);
      System.out.printf("Federal tax: $%,d\n", federalTax);

      // Step #6: Calculate tax due
      due = calcTaxDue(federalTax, withheld);
      System.out.printf("Tax due: $%,d\n", due);
   }
}