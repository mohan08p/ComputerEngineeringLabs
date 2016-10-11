**Aim:** Write a program to demonstrate strength of RSA.

**Theory:**

RSA is an algorithm used by modern computers to encrypt and decrypt messages. It is an asymmetric cryptographic algorithm. Asymmetric means that there are two different keys. This is also called public key cryptography, because one of them can be given to everyone. The other key must be kept private. It is based on the fact that finding the factors of an integer is hard (the factoring problem). RSA stands for Ron Rivest, Adi Shamir and Leonard Adleman, who first publicly described it in 1978. A user of RSA creates and then publishes the product of two large prime numbers, along with an auxiliary value, as their public key. The prime factors must be kept secret. Anyone can use the public key to encrypt a message, but with currently published methods, if the public key is large enough, only someone with knowledge of the prime factors can feasibly decode the message.

**Operation:**

RSA involves a public key and private key. The public key can be known to everyone; it is used to encrypt messages. Messages encrypted using the public key can only be decrypted with the private key. The keys for the RSA algorithm are generated the following way:

     Choose two different large random prime numbers p and q.

     Calculate n = p * q.

     n is the modulus for the public key and the private keys.

     Calculate the totient:phi(n) = (p-1)(q-1).

     Choose an integer e such that 1 < e < phi(n), and e is coprime to phi(n) ie: e and phi(n) share no factors  
     other than 1; gcd(e, phi(n)) = 1.
     
     e is released as the public key exponent.

     Compute d to satisfy the congruence relation de ~= 1 mod(phi(n)) ie: de = 1 + k * phi(n) for some integer k.
     
     d is kept as the private key exponent.

The public key is made of the modulus n and the public (or encryption) exponent e.

The private key is made of the modulus n and the private (or decryption) exponent d which

must be kept secret.

Encrypting messages:

Alice gives her public key ( & ) to Bob and keeps her private key secret. Bob wants to send message M to Alice.

First he turns M into a number smaller than  by using an agreed-upon reversible protocol known as a padding scheme. He then computes the ciphertext  corresponding to:

This can be done quickly using the method of exponentiation by squaring. Bob then sends  to Alice.

Decrypting messages:

Alice can recover  from  by using her private key  in the following procedure:

Given , she can recover the original message M.

The decryption procedure works.

Example:

Here is an example of RSA encryption and decryption. The parameters used here are artificially small, but you can also use OpenSSL to generate and examine a real key pair.

1. Choose two random prime numbers 

2. p = 61  and  q = 53

3. Compute  n = p * q In this case, n = 61 * 53 = 3233

4. Compute the totient  phi(n) = (p-1) * (q-1)
     phi(n) = 3120

5. Choose e > 1 coprime to 3120, e = 17

6. Choose d  to satify de ~= 1 , i.e. d = e^-1 (mod(phi(n)))
     d = 2753

7. 17 * 2753 = 46801 = 1 + 15 * 3120. 

     The public key is (n = 3233, e = 17). For a padded message  the encryption function is:

     m = c^d mod n  = m^17 mod 3233

     The private key is (n = 3233, d = 2753). The decryption function is:

     m = c^d mod n = c^2753 mod 3233

For e.g. to encrypt m = 123, we calculate,

     c = 123^17 mod 32 = 85

To decrypt c = 855, we calculate,

     m = 855^2753 mod 3233 = 123   

Both of these calculations can be computed efficiently using the square-and-multiply algorithm for modular exponentiation.

**Conclusion:**

Thus we have studies RSA algorithm for encryption and decryption, using asymmetric key’s, i.e. using two different keys’ for encryption and decryption. We have successfully implemented a program to demonstrate the working of a RSA algorithm.
