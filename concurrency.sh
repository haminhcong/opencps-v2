touch test.txt
echo "test" >> test.txt
git add .
git commit -m "check concurrency"
git push

sleep 3

echo "test" >> test.txt
git add .
git commit -m "check concurrency"
git push

sleep 3 

echo "test" >> test.txt
git add .
git commit -m "check concurrency"
git push
