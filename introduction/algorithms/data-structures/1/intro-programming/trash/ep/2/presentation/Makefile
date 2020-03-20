all: presentation clean

presentation:
	pdflatex presentation.tex
	makeindex presentation.tex
	pdflatex presentation.tex
	pdflatex presentation.tex

clean:
	rm -rf presentation.{aux,blg,ilg,ind,log,toc}
