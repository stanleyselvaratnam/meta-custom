all: hellocustom

hellocustom: main.c
	$(CC) $(CFLAGS) $(LDFLAGS) -o hellocustom main.c

install:
	mkdir -p $(DESTDIR)/usr/bin
	install -m 0755 hellocustom $(DESTDIR)/usr/bin/

clean:
	rm -f hellocustom
