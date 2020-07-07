package Project_Euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Project_Euler {
	
	public static void main(String[] args) {
		
		Project_Euler project = new Project_Euler();
		
		/*
		int ans0001 = getProb0001();
		System.out.println(ans0001);
		
		int ans0002 = getProb0002();
		System.out.println(ans0002);
		
		double ans0003 = getProb0003();
		System.out.println(ans0003);

		double ans0004 = getProb0004();
		System.out.println(ans0004);
		
		double ans0005 = getProb0005();
		System.out.format("%.0f", ans0005);
		
		double ans0006 = getProb0006();
		System.out.format("%.0f", ans0006);
		
		double ans0007 = getProb0007();
		System.out.format("%.0f", ans0007);
		
		double ans0008 = getProb0008();
		System.out.format("%.0f", ans0008);
		
		int ans0009 = getProb0009();
		System.out.println(ans0009);
		
		double ans0010 = getProb0010();
		System.out.format("%.0f", ans0010);
		*/
		
		double ans0011 = project.getProb0011();
		System.out.format("%.0f", ans0011);
		
		//List<Double> test = getPrimeFactors(2520);
		//System.out.println(test);
		
	}
	
	public int getProb0001() {
		
		int sum = 0;
		
		int multA  = 3;
		int multB  = 5;
		int maxNum = 1000;
		
		List<Integer> multAList = new ArrayList<Integer>();
		List<Integer> multBList = new ArrayList<Integer>();
		
		int i = 1;
		boolean doFlagA = true;
		while (doFlagA == true) {
			if (i*multA<maxNum) {
				multAList.add(i*multA);
				i++;
			} else {
				doFlagA = false;
			}
		}
		
		int j = 1;
		boolean doFlagB = true;
		while (doFlagB == true) {
			if (j*multB<maxNum) {
				multBList.add(j*multB);
				j++;
			} else {
				doFlagB = false;
			}
		}
		
		// Use HashSet to store combined list, automatically removes duplicates
		Set<Integer> overallSet = new HashSet<Integer>();
		overallSet.addAll(multAList);
		overallSet.addAll(multBList);
		List<Integer> overallList = new ArrayList<Integer>();
		overallList.addAll(overallSet);
		
		// Sum up the list to calculate the answer
		for (int k=0; k<overallList.size(); k++) {
			sum = sum + overallList.get(k);
		}
		
		return sum;
	}
	
	public int getProb0002() {
		
		int sum = 0;
		
		int maxNum = 4000000;
		
		List<Integer> fib = new ArrayList<Integer>();
		fib.add(1);
		fib.add(2);
		
		int i = 2;
		boolean doFlag = true;
		while (doFlag == true) {
			Integer nextNum = fib.get(i-1) + fib.get(i-2);
			if (nextNum<maxNum) {
				fib.add(nextNum);
				i++;
			} else {
				doFlag = false;
			}
		}
		
		for (int j=0; j<fib.size(); j++) {
			if (fib.get(j) % 2 ==0) {
				sum = sum + fib.get(j);
			}
		}
		
		return sum;		
	}

	public double getProb0003() {
		
		double largestFactor = 0;
		
		double number = 600851475143D;
		
		List<Double> factors = new ArrayList<Double>();
		factors = getPrimeFactorsEfficient(number);
		
		largestFactor = factors.get(factors.size()-1);
		
		return largestFactor;	
	}

	public int getProb0004() {
		
		int largestPalindrome = 0;
		
		int maxNum = 999;
		List<Integer> list = new ArrayList<Integer>();
		for (int i=1; i<=maxNum; i++) {
			for (int j=1; j<=maxNum; j++) {
				list.add(i*j);
			}
		}
		Collections.sort(list);
		
		int test = 0;
		for (int i=0; i<list.size(); i++) {
			test = list.get(list.size()-1-i); 
			if ( isPalindrome(String.valueOf(test)) ) {
				largestPalindrome = test;
				break;
			}
		}

		return largestPalindrome;
	}
	
	public double getProb0005() {
		
		double ans = 0;
		
		double maxNum = 20;
		
		List<Double> fullList = new ArrayList<Double>();
		for (int i=2; i<=maxNum; i++) {
			List<Double> factors = getPrimeFactorsEfficient(i);
			
			for (Double f:factors) {
				for (Double l:fullList) {
					if (l.equals(f)) {
						fullList.remove(f);
						break;
					}
				}
			}
			
			fullList.addAll(factors);		
		}
		
		ans = getProduct(fullList);
		return ans; 
	}
	
	public double getProb0006() {
		
		double diff = 0;
		
		int maxNum = 100;
		
		diff = getSumOfPower(maxNum, 1)*getSumOfPower(maxNum, 1)-getSumOfPower(maxNum,2);
		
		return diff;		
	}
	
	public double getProb0007() {
		
		double ans = 0;
		
		int numPrime = 10001;
			
		double j=1;
		for (int i=2; i<=numPrime; i++) {
			boolean flag = true;
			while (flag==true) {
				double testNum = j*2 + 1;
				if (getPrimeFactorsEfficient(testNum).size()==1) {
					ans = testNum;
					flag=false;
				} 
				j++;
			}
		}
		return ans;
	}
	
	public double getProb0008() {
		
		double product = 0;
		
		int digits = 13;
		
		String crazyNumber = "73167176531330624919225119674426574742355349194934"
				+ "96983520312774506326239578318016984801869478851843"
				+ "85861560789112949495459501737958331952853208805511"
				+ "12540698747158523863050715693290963295227443043557"
				+ "66896648950445244523161731856403098711121722383113"
				+ "62229893423380308135336276614282806444486645238749"
				+ "30358907296290491560440772390713810515859307960866"
				+ "70172427121883998797908792274921901699720888093776"
				+ "65727333001053367881220235421809751254540594752243"
				+ "52584907711670556013604839586446706324415722155397"
				+ "53697817977846174064955149290862569321978468622482"
				+ "83972241375657056057490261407972968652414535100474"
				+ "82166370484403199890008895243450658541227588666881"
				+ "16427171479924442928230863465674813919123162824586"
				+ "17866458359124566529476545682848912883142607690042"
				+ "24219022671055626321111109370544217506941658960408"
				+ "07198403850962455444362981230987879927244284909188"
				+ "84580156166097919133875499200524063689912560717606"
				+ "05886116467109405077541002256983155200055935729725"
				+ "71636269561882670428252483600823257530420752963450";
		String[] array = crazyNumber.split("");
		int n = array.length;
				
		int combinations = n - digits + 1;
		for (int i=0; i<combinations; i++) {
			double testProduct = 1;
			for (int j=0; j<digits; j++) {
				testProduct = testProduct*Double.valueOf(array[i+j]);
			}
			if (testProduct>product) {
				product = testProduct;
			}
		}
		return product;		
	}
	
	public int getProb0009() {
		
		int[] ans = new int[3];
		
		// for any triangle with perimeter N, no edge can be longer than N/2
		int maxSum  = 1000;
		int maxEdge = (int) 1000/2;
		
		// initiate arrays of 1 to N (1-indexed)
		// pre-calculate squares of the array
		int[] num = new int[maxEdge+1];
		int[] squ = new int[maxEdge+1];
		for (int i=0; i<maxEdge+1; i++) {
			num[i] = i;
			squ[i] = i*i;
		}
		
		// let "a" be the side to iterate on, starting with 1
		// let "b" be the side orthogonal to "a"
		// let "c" be the hypotenuse
		// use:
		//	a+b+c=1000
		//	c<1000/2
		//  therefore, b<1000/2-a/2
		boolean flag = false;
		for (int a=1 ; a<maxSum/(2+Math.sqrt(2)) ; a++) {
			for (int b=maxEdge-a ; b<maxEdge-a/2 ; b++) {
				int c = maxSum - a - b;
				if (squ[a]+squ[b]==squ[c]) {
					ans[0] = a;
					ans[1] = b;
					ans[2] = c;
					flag = true;
					break;
				}
			}
			if (flag==true) {break;}
		}
		System.out.println(Arrays.toString(ans));
		return ans[0]*ans[1]*ans[2];
	}

	public double getProb0010() {
		
		double sum = 0;
		
		double maxNum = 2000000;
		
		// start with 2 (first prime number)
		for (double i=2; i<=maxNum; i++) {
			if (getPrimeFactorsEfficient(i).size()==1) {
				sum += i;
			}
		}
		return sum;
	}
	
	public double getProb0011() {
		
		double product = 0;
		
		int dimX = 20;
		int dimY = 20;
		int[] xIdx = new int[4];
		int[] yIdx = new int[4];
		
		String gridInput = 	"08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 " + 
							"49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 " + 
							"81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 " + 
							"52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 " + 
							"22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 " + 
							"24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 " + 
							"32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 " + 
							"67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 " + 
							"24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 " + 
							"21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 " + 
							"78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 " + 
							"16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 " + 
							"86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 " + 
							"19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 " + 
							"04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 " + 
							"88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 " + 
							"04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 " + 
							"20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 " + 
							"20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 " + 
							"01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
		String[] gridSplit = gridInput.split(" ");
		int[][] grid = new int[dimY][dimX];
		int counter = 0;
		for (int i=0; i<dimY; i++) {
			for (int j=0; j<dimX; j++) {
				grid[i][j] = Integer.parseInt(gridSplit[counter]);
				counter += 1;
			}
		}
		//System.out.println(Arrays.deepToString(grid));
		
		// loop over horizontal set of 4 adjacent numbers
		for (int i=0; i<dimY; i++) {
			for (int j=0; j<dimX-4+1; j++) {
				double testProduct = grid[i][j]*grid[i][j+1]*grid[i][j+2]*grid[i][j+3];
				if (testProduct>product) {
					product = testProduct;
					xIdx[0] = j		;	 yIdx[0] = i;
					xIdx[1] = j+1	;	 yIdx[1] = i;
					xIdx[2] = j+2	;	 yIdx[2] = i;
					xIdx[3] = j+3	;	 yIdx[3] = i;
				}
			}
		}
		// loop over vertical set of 4 adjacent numbers
		for (int i=0; i<dimY-4+1; i++) {
			for (int j=0; j<dimX; j++) {
				double testProduct = grid[i][j]*grid[i+1][j]*grid[i+2][j]*grid[i+3][j];
				if (testProduct>product) {
					product = testProduct;
					xIdx[0] = j		;	 yIdx[0] = i;
					xIdx[1] = j  	;	 yIdx[1] = i+1;
					xIdx[2] = j  	;	 yIdx[2] = i+2;
					xIdx[3] = j  	;	 yIdx[3] = i+3;
				}
			}
		}
		// loop over diagonal set of 4 adjacent numbers (fwd)
		for (int i=0; i<dimY-4+1; i++) {
			for (int j=0; j<dimX-4+1; j++) {
				double testProduct = grid[i][j]*grid[i+1][j+1]*grid[i+2][j+2]*grid[i+3][j+3];
				if (testProduct>product) {
					product = testProduct;
					xIdx[0] = j		;	 yIdx[0] = i;
					xIdx[1] = j+1	;	 yIdx[1] = i+1;
					xIdx[2] = j+2	;	 yIdx[2] = i+2;
					xIdx[3] = j+3	;	 yIdx[3] = i+3;
				}
			}
		}
		// loop over diagonal set of 4 adjacent numbers (bck)
				for (int i=0; i<dimY-4+1; i++) {
					for (int j=0; j<dimX-4+1; j++) {
						double testProduct = grid[i][j+3]*grid[i+1][j+2]*grid[i+2][j+1]*grid[i+3][j];
						if (testProduct>product) {
							product = testProduct;
							xIdx[0] = j+3	;	 yIdx[0] = i;
							xIdx[1] = j+2	;	 yIdx[1] = i+1;
							xIdx[2] = j+1	;	 yIdx[2] = i+2;
							xIdx[3] = j 	;	 yIdx[3] = i+3;
						}
					}
				}
		
		return product;
	}
	
	/*
	public double getProb0708() {
		
		double sum = 0;
		
		double bigN = (long) 100000;
		
		for (double i=1L; i<=bigN; i++) {
			if (i==1) {
				sum = sum + 1;
			} else {
				List<Double> factors = getPrimeFactors(i);
				int numberOfFactors = factors.size();
				double product = Math.pow(2, numberOfFactors);
				sum = sum + product;
			}
			if (i%100000 == 0) {
				System.out.println(i);
			}
		}
		
		return sum;
	}
	*/

	
	public List<Double> getPrimeFactors(double number) {
		
		List<Double> factors = new ArrayList<Double>();
		boolean doFlag = true;
		double i = 2; // try factor, increment this
		double num = number;
		while (doFlag==true) {
			if (num % i == 0  &&  i <= num) {
				factors.add(i);
				num = num/i;
			} else if (num % i != 0  &&  i <= num) {
				i++;
			} else {
				doFlag = false;
			}
		}
		
		return factors;
	}

	public List<Double> getPrimeFactorsEfficient(double n) {
		
		List<Double> factors = new ArrayList<Double>();
		
		// Print the number of 2s that divide n 
        while (n%2==0) 
        { 
            //System.out.print(2 + " ");
        	factors.add((double) 2);
            n /= 2; 
        } 
  
        // n must be odd at this point.  So we can 
        // skip one element (Note i = i +2) 
        for (double i = 3; i <= Math.sqrt(n); i+= 2) 
        { 
            // While i divides n, print i and divide n 
            while (n%i == 0) 
            { 
                //System.out.print(i + " "); 
            	factors.add(i);
                n /= i; 
            } 
        } 
  
        // This condition is to handle the case when 
        // n is a prime number greater than 2 
        if (n > 2) {
            //System.out.print(n);
        	factors.add(n);
        }
        
        return factors;
	}

	public boolean isPalindrome(String string) {
		String[] array = string.split("");
		int len = array.length;
		boolean flag = true;
		for (int i=0; i<len/2; i++) {
			if (!array[i].equals(array[len-i-1])) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public <T> List<T> getIntersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
	
	public Double getProduct(List<Double> list) {
		Double product = 1D;
		for (int i=0; i<list.size(); i++) {
			product = product * list.get(i);
		}
		return product;
	}
	
	public Double getSumOfPower(double n, int p) {
		Double sum = null;
		if (n>=1) {
			if (p==1) {
				sum = n*(n+1)/2;
			} else if (p==2) {
				sum = n*(n+1)*(2*n+1)/6;
			} else if (p==3) {
				sum = n*n*(n+1)*(n+1)/4;
			}
		}
		return sum;
	}
	
}
