all:
	gcc gen_key.c -o gen_key -lcrypto -Wall -g -O0
	gcc filencrypt.c -o filencrypt -lcrypto -Wall -g -O0

clean:
	rm -f filencrypt gen_key keyfile plain_file*

test: all
	echo "deep secrets" > plain_file &&\
	./gen_key keyfile &&\
	./filencrypt keyfile -e plain_file &&\
	./filencrypt keyfile -d plain_file.aes &&\
	diff plain_file.aes.asc plain_file
