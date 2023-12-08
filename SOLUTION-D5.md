You are to describe your process for selecting optimizations, describe each optimization that is included, and describe the evidence that supports its unique benefit in optimizing SIP programs.

Tail Call Recursion Elimination (tail.tip)
    I first started with tail call recursion elimination because it has been something that I thought about often last year
    in DSA2 when we were discussing recursive solutions with an immediate base case. Thus, knowing it was applicable and did
    come up with decent frequency, and seeing an optimization that freed that stack space, I went to work implementing it.
    The microbenchmark showed the significant speed up as by converting the recursive function into a while loop, not only
    did the optimization limit the overhead of placing all the calls on the stack (which the microbenchmark highlights),
    but it also allows the while loop to benefit from additional optimizations. The optimization reduced the time needed to
    run the program by an order of ten, which would greatly assist programs that use recursive functions, especially due
    to TIP's nature of having the return statement forced to be at the end of the function. Tail call recursion elimination
    thus helps greatly to reduce recursive overhead in TIP.

Loop Unroll (unroll.tip)
	Modifying TIP limited us in what types of optimizations we could do. One of the optimizations I had wanted to add
	was a vector optimization to loops. It would have allowed a while or for loop that iterated through an array to
	instead be able to replace the loop with a single operation. However, as we were working on the TIP repository,
	I instead needed to find an optimization that did not involve arrays. While I had been looking at array optimizations,
	I had come across the loop unroll optimization, which lowered the cost of while loops by lowering the amount of jumps
	back to the top that were needed. As TIP's only loops are while loops, reducing the cost of using while loops is highly
	beneficial to even the most mundane TIP program!

Function Inlining
    Inlining seemed like it would open the door for more potential optimizations by replacing function calls with the body
    of the function. We tried multiple methods, first adding an inline

Loop Rotation
    The initial goal for using loop rotation was as setup for an LICM pass. The loop rotation pass converts loops in a
    do-while style of loop and ensures that the loop is in loop simplify form when finished. This not only supports
    further loop optimization, but in itself provides a decent speedup. Again focusing on the fact that TIP only provides
    access to while loops, this while loop specific optimization is perfect for use in TIP. Unlike unrolling,
    which provides more of a benefit to long loops, rotation provides a benefit to smaller loops or loops that are
    guaranteed to run by removing that one unnecessary jump. This loop optimization via removing jumps is quite similar
    to unrolling, but thankfully both of these optimizations can be applied in conjunction while still providing benefit.
    A microbenchmark has been added titled "rotnroll.tip" to illustrate how these are not mutually exclusive. The fact
    that these two optimizations work in conjunction and provide such a benefit to while loops (and loop rotation's
    while loop specific nature) makes them perfect for optimizing TIP code.

