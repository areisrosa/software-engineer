# OpenSSL demonstration

Simple demonstration code using libcrypt from OpenSSL. Presentation slides  in
Portuguese.

_Disclaimer: there's no guarantee of security using this program, use if just for
study!_

## Dependencies:

- For C code:
	- OpenSSL development files
	- On Arch Linux:
		- `sudo pacman -S openssl`
	- On Debian/Ubuntu:
		- `sudo apt install openssl libssl-dev`

- For Python code:
	- `pip install cryptography`

## _Challenge!_

Clone this repository and implement the `decrypt()` function!

```shell
$ git clone https://gitlab.com/andrealmeid/openssl-demo
```

If you want to see the answer, you can check on this
[link](https://gitlab.com/andrealmeid/openssl-demo/tree/solution) or with
`git checkout solution`.

### Bonus challenge

We also have some classic simetric challanges
[here](presentation/simetric_challs.md), check it out if you solve them.

## Using with C source files

After you have all dependencies, you can compile with and test with:

```shell
$ cd c/
$ make
$ make test
```

- To generate a key:

```shell
$ ./gen_key <keyfile>
```

- To encrypt some file:

```shell
$ ./filencrypt <keyfile> -e <plain_file>
```

- To decrypt some file:

```shell
$ ./filencrypt <keyfile> -d <encrypted_file>
```

## Using with Python scripts

After you have all dependencies, you can test with:

```shell
$ cd python/
$ make test
```

- To generate a key:

```shell
$ python3 gen_key.py <keyfile>
```

- To encrypt some file:

```shell
$ python3 filencrypt.py <keyfile> -e <plain_file>
```

- To decrypt some file:

```shell
$ python3 filencrypt.py <keyfile> -d <encrypted_file>
```

## License

[This project is licensed under the GNU General Public License v2.0.](LICENSE.md)
