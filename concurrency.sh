echo "Test concurrency" >> concurrency.txt

git add .
git commit -m "test concurrency 1"
git push

sleep 10

echo "Test concurrency" >> concurrency.txt

git add .
git commit -m "test concurrency 2"
git push


sleep 10
echo "Test concurrency" >> concurrency.txt

git add .
git commit -m "test concurrency 3"
git push

