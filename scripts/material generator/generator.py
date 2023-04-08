import sys
import constants
import json

lineArray = []
items = []

def write_to_file(fileName):
    file = open(fileName, 'w')
    file.write(constants.header)
    file.write(',\n'.join(lineArray))
    file.write(constants.footer)

# WRITTEN_BOOK(387, 16)
def write_line():
    for item in items:
        name = item['name']
        if 'varName' in item:
            name = item['varName']
        lineArray.append('    ' + name.upper() + "(" + item['id'] + ", 1)")

        

if __name__ == '__main__':
    if len(sys.argv) == 0:
        print("isim gir")
        pass
    items = json.load(open(sys.argv[1]))
    write_line()
    write_to_file(sys.argv[2])