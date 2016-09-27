
git clone https://github.com/deepakmarathe/sudoku-solver.git 
cd sudoku-solver


#Build
    mvn clean install 

#Execution
##to test the programme
java -cp target/-test 

to run the program on an file containing sudoku puzzle $ProjectDir/input/input.txt
-inputFile /Users/dmarathe/work-personal/all-things-programming/puzzle-solver/input/input.txt -outputFile=/Users/dmarathe/work-personal/all-things-programming/puzzle-solver/output/output.txt -delimiter "," -dimention 9




 cd puzzle-solver &&  mvn clean install && java -cp target/puzzle-solver-1-jar-with-dependencies.jar com.deepakm.puzzles.sudoku.SudokuSolverDriver -inputFile /Users/dmarathe/work-personal/all-things-programming/puzzle-solver/input/input.txt -outputFile /Users/dmarathe/work-personal/all-things-programming/puzzle-solver/output/output.txt -delimiter "," -dimention 9

