Project Deliverable 3 Solution
Team: Charlotte Miller, Sebastian Fugle

In implementing semantic analysis for SIP, we added the new types bool and array to TipType. We also had to change the type constraints to allow for the SIP extensions, which we did through editing the endVisitor methods in TipTypeVisitor. 

One of the difficulties in this deliverable was implementing constraints for ambigious situations, such as for statements where it could be both an int or a boolean. For example, when we initially implemented the constraints for while and if statements, we constrained the condition to be a boolean. However, this caused the TIP functionality without the SIP extensions to not work, as it formerly accepted ints. We didn't know how to allow it to accept both ints and booleans without accepting anything else. 

Ultimately we figured out a way to allow either ints or booleans for while and if, and we decided that > should always return a boolean, as it doesn't make sense for the return value to be undefined/based on other constraints, and the functionality of a>b as a boolean is far more essential than a>b as an int: there's no purpose for a>b as an int that isn't replacable with a>b as a boolean. 

For testing, we used the same format as the tests that were already created and created new tests that covered the SIP extensions, making sure all the new features were tested at least once. Some of the old tests were no longer valid because of the new constraints added (for example, while and if expressions were no longer constrained to be ints). We updated these tests to reflect the desired behavior, to ensure our constraints were working as expected for SIP and TIP features. 

