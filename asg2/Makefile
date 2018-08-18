CC = gcc
CFLAGS = -Wall -Wextra -Wpedantic -Werror -std=c99
OBJECTS = apint.o test.o

.PHONY: all
all: test

test: $(OBJECTS)
	$(CC) $(CFLAGS) $(OBJECTS) $(CFLAGS) -o test

apint.o: apint.c
	$(CC) $(CFLAGS) -c apint.c


.PHONY: clean
clean:
	rm -f $(OBJECTS) paint test


