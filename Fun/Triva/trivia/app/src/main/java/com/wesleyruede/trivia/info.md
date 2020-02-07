# MainActivity Info

## Line 23:
    Get the array of arrays with the corresponding String and  Boolean Question singleton instance. The internet processes
    requests asynchronously so the app must handle null responses and wait for the queue to respond with the next element in
    the array. QuestionBank.getQuestions() = [["question",true"],["Question",false]] or null. Calling the class and method
    allows us to implement the Interface, thus overriding the default behavior of the ArrayList and pass the json response
    (see: [[],[]]) directly to MainActivity.
