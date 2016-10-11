**Aim:** Write a program to implement product cipher/Playfair cipher.

**Theory:**

In cryptography, a product cipher combines two or more transformations in a manner intending that the resulting cipher is more secure than the individual components to make it resistant to cryptanalysis. The product cipher combines a sequence of simple transformations such as substitution, permutation, and modular arithmetic. The concept of product ciphers is due to Claude Shannon, who presented the idea in his foundational paper, Communication Theory of Secrecy Systems.

In the days of manual cryptography, product ciphers were a useful device for cryptographers, and in fact double transposition or product ciphers on key word-based rectangular matrices were widely used. There was also some use of a class of product ciphers known as fractionation systems, wherein a substitution was first made from symbols in the plaintext to multiple symbols (usually pairs, in which case the cipher is called a biliteral cipher) in the ciphertext, which was then encrypted by a final transposition, known as superencryption. One of the most famous field ciphers of all time was a fractionation system, the ADFGVX employed by the German army during World War I. This system used a 6 × 6 matrix to substitution-encrypt the 26 letters and 10 digits into pairs of the symbols A, D, F, G, V, and X. The resulting biliteral cipher was then written into a rectangular array and route encrypted by reading the columns in the order indicated by a key-word

**Implementation:**

For our implementation of product cipher we have considered substitution and transposition cipher.

The steps for generation of ciphertext are:

Encrypt plaintext using substitution cipher algorithm 

Encrypt the ciphertext obtained above using transposition cipher algorithm. 


**Conclusion:**

The ciphertext thus generated is sent over to the receiver's side. The decryption process is inverse of the generation process with transposition being inverted first followed by substitution.