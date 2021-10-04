import java.math.BigInteger;
import java.util.Random;

public class HomeworkRSA 
{

	private BigInteger p, q;
   //p and q for large primes
   
   //need total be the (p*q)
   //need diff key of p-1 and q-1
   //need exp for inverse'
   //modder for mod equations
   private BigInteger total, diff, exp, modder; 
	private int bitLength = 512;

	public void Generation() 
	{
		Random rnd = new Random();

      p = new BigInteger("0");
      q = new BigInteger("0");
     
		while (p.compareTo(q) == 0) 
		{
			p = BigInteger.probablePrime(bitLength, rnd);
			q = BigInteger.probablePrime(bitLength, rnd);
		}
		
		// Let total = p * q
		total = p.multiply(q);

		System.out.println("total: " + total);

		//diff going to be p-1 and q-1 multiplied
		diff = ((p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)));

		// need e to be odd ("You need to begin with an odd integer and count by 2")
		exp = new BigInteger("1");
      exp = exp.add(new BigInteger("2")); //need 3

		while (exp.gcd(diff).intValue() > 1) 
		{
			exp = exp.add(new BigInteger("2"));
		}

		System.out.println("exp: " + exp);

		// Compute modder such that (exp * modder) % diff = 1 (modder = multiplicative inverse of (exp mod diff))
		diff = exp.modInverse(diff);

		System.out.println("diff: " + diff);
	}

	// c = m^exp mod total, m < total        
   //use modPow(BigInteger exponent, BigInteger m)
	public BigInteger Encryption(BigInteger m) 
	{
		// m.compareTo(total) --- m < n = -1, m == n = 0, m > n = 1
		if (m.compareTo(total) == -1) 
		{
			BigInteger encrypt = m.modPow(exp, total);

			return encrypt;
		} 
		else 
		{
			return null;
		}
	}

	// m = c^diff mod total
	public BigInteger Decryption(BigInteger c) 
	{
		BigInteger decrypt = c.modPow(diff, total);
		return decrypt;
	}

	// s = m^diff mod total, m < total
	public BigInteger Signature(BigInteger m) 
	{
		// m.compareTo(total) --- m < total = -1
		if (m.compareTo(total) == -1) 
		{
			BigInteger s = m.modPow(diff, total);
			return s;
		} 
		else 
		{
			return null;
		}
	}


//Verifcation using s
	public BigInteger Verification(BigInteger s) 
	{
		BigInteger m = s.modPow(exp, total);
		return m;
	}

	public static void main(String[] args) 
	{
		Random rnd = new Random();
		
      	String messageA = "This is the first message to test.";
      	String messageB = "THIS is the second message to test.";
      	String messageC = "There are many different languages to program in but I choose JAVA.";
      	String messageD = "Encryption and Decryption save both uPPer and lower case words as well as symbols %$@";


		HomeworkRSA rsa = new HomeworkRSA();
		rsa.Generation();
		System.out.print("\n");


      //need my messages in BigInt form not just int
		BigInteger messageBigIntA = new BigInteger(messageA.getBytes());
		BigInteger messageVerifyA = new BigInteger(messageA.getBytes());
      	BigInteger messageBigIntB = new BigInteger(messageB.getBytes());
		BigInteger messageVerifyB = new BigInteger(messageB.getBytes());
      	BigInteger messageBigIntC = new BigInteger(messageC.getBytes());
		BigInteger messageVerifyC = new BigInteger(messageC.getBytes());
		BigInteger messageBigIntD = new BigInteger(messageD.getBytes());
		BigInteger messageVerifyD = new BigInteger(messageD.getBytes());

     //each message printed in order ----
      System.out.println("MessageA: " + messageA);
      System.out.println("MessageB: " + messageB);
      System.out.println("MessageC: " + messageC);
      System.out.println("MessageD: " + messageD);
      //CYCLE THROUGH THE MESSAGES
      BigInteger encryptedA = rsa.Encryption(messagoBigIntA);
      BigInteger encryptedB = rsa.Encryption(messagoBigIntB);
      BigInteger encryptedC = rsa.Encryption(messagoBigIntC);
      BigInteger encryptedD = rsa.Encryption(messagoBigIntD);
      
      messageBigIntA = rsa.Decryption(encryptedA);
      messageBigIntB = rsa.Decryption(encryptedB);
      messageBigIntC = rsa.Decryption(encryptedC);
      messageBigIntD = rsa.Decryption(encryptedD);
      
      System.out.println("EncryptedB: " + encryptedB);
      System.out.println("EncryptedC: " + encryptedC);
      
      System.out.println("DecryptedB: " + messageBigIntB);
      System.out.println("DecryptedC: " + messageBigIntC);
      
      String bigToMessageA = new String(messageBigIntA.toByteArray());
      String bigToMessageB = new String(messageBigIntB.toByteArray());
      String bigToMessageC = new String(messageBigIntC.toByteArray());
      String bigToMessageD = new String(messageBigIntD.toByteArray());
      
      System.out.println("B from BigInt Decrypt: " + bigToMessageB);
      System.out.println("C from BigInt Decrypt: " + bigToMessageC);
      //need to verify one
      //verify using original phrase prior to encrypt+decryption+toMessage
      BigInteger sigA = rsa.Signature(messageVerifyA);
      System.out.print("SignatureA: " + sigA);
      messageVerify = rsa.Verification(signature);
      System.out.println("VerifcationA: " + messageVerifyA);
      String backToStringA = new String(messageVerify.toByteArray());
      System.out.println("DecryptedA: " + backToStringA);
      System.out.print("\n");
		
		// Displays message of verification
		if (messageBigIntA.compareTo(messageVerifyA) == 0)
			System.out.println("This message is verified!");
		else
			System.out.println("This message is not verified!");

		
		System.out.println();
		
      
      //Prove Homeomorphic aka enc(messageA) * enc(messageB) = enc(messageA*messageB)
		System.out.println("- Proving Homeomorphic Property -");
		//create new iterations of prior messages for homeo
		BigInteger homeoMessageA = new BigInteger(messageA.getBytes());
		BigInteger homeoMessageB = new BigInteger(messageB.getBytes());

		BigInteger homeoEncryptA = rsa.Encryption(homeoMessageA);
		BigInteger homeoEncryptB = rsa.Encryption(homeoMessageB);

		//print out
		System.out.println("MessageA: " + messageA);
		System.out.println("MessageB: " + messageB);
		System.out.println("MessageA BigInt: " + homeoMessageA);
		System.out.println("MessageB BigInt: " + homeoMessageB);
		System.out.println("MessageA Encrypt: " + homeoEncryptA);
		System.out.println("MessageB Encrypt: " + homeoEncryptB);

		//Evaluate Encryption(MessageA * MessageB) = Encryption(MessageA) * Encryption(messageB)
		BigInteger leftSide = new BigInteger(homeoMessageA.multiply(homeoMessageB));
		BigInteger leftEncrypt = new BigInteger(rsa.Encryption(leftSide));

		BigInteger rightEncrypt = new BigInteger(homeoEncryptA.multiply(homeoEncryptB));

		System.out.println("Encryption(MessageA * MessageB): " + leftEncrypt);
		System.out.println("Encryption(MessageA) * Encryption(messageB): " + rightEncrypt);

		//Decrypt
		BigInteger leftDecrypt = rsa.Decryption(leftEncrypt);
		System.out.println("Decryption message Left Side " + leftDecrypt);
		BigInteger rightDecrypt = rsa.Decryption(rightEncrypt);
		System.out.println("Decryption message Right Side: " + rightDecrypt);
		
		// Compare the two. Does E(m1) * E(m2) = E(m1 * m2)?
		if (rightDecrypt.compareTo(leftDecrypt) == 0)
		{
			System.out.println("Decryption of both messages are equal : Therefor Homeomorphic");
		}
		else
		{
			System.out.println("The Homeomorphic property is not proven.");
		}
	}
}