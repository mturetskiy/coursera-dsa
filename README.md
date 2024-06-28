# coursera-dsa
Project with code written for Algorithms and Data Structures course on Coursera (by Princenton)

# preparation steps:
1. To build the project specific algs4.jar library is required to be available for maven.
2. If you are doing the project from the scratch, you need to deploy this jar file explicitly to some local repository and let maven use that repo in the project (see repositories section in pom.xml).
3. To download jar: https://algs4.cs.princeton.edu/code/algs4.jar and put it to <project_root>/lib dir.
4. To install it to the repo:
    cd <project root>
    mvn deploy:deploy-file -DgroupId=edu.princenton.cs -DartifactId=algs4 -Dversion=1.0 -Durl=file:./lib -DrepositoryId=lib -DupdateReleaseInfo=true -Dfile=./lib/algs4.jar
5. To build it from cmdline:
   javac -cp ".:../../../../lib/edu/princenton/cs/algs4/1.0/*"  RandomWord.java
6. To Run it from cmdline:
7. java -cp ".:../../../../lib/edu/princenton/cs/algs4/1.0/*"  RandomWord