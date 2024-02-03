FILE_NAME=$1
name=$(sed 's/.java//g' <<< "$FILE_NAME")
echo $name
javac $name.java
java $name
rm $name.class