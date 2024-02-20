FILE_NAME=$1
name=$(sed 's/.java//g' <<< "$FILE_NAME")
javac $name.java
java $name
rm *.class