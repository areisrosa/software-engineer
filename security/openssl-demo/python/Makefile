clean:
	rm -f keyfile filencrypt plain_file*

test:
	echo "deep secrets" > plain_file &&\
	python3 gen_key.py keyfile &&\
	python3 filencrypt.py keyfile -e plain_file &&\
	python3 filencrypt.py keyfile -d plain_file.aes &&\
	diff plain_file.aes.asc plain_file
