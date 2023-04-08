import sys
import constants
import json

lines = []
items = []

def write_to_file(fileName):
    file = open(fileName, 'w')
    file.write(constants.header)
    file.write('\n'.join(lines) + '\n')
    file.write(constants.footer)

def parse_item():
    for item in items:
        name = item['name']
        if "varName" in item:
            name = item['varName']
        lines.append('        ' + 'public static final int ' + name.upper() + ' = ' + item['id'] + ';')

if __name__ == '__main__':
    if len(sys.argv) < 2:
        pass
    items = json.load(open(sys.argv[1]))
    parse_item()
    write_to_file(sys.argv[2])