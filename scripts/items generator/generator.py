import sys
import json
import constants

lineArray = []
items = []

def write_to_file(fileName):
    file = open(fileName, 'w')
    file.write(constants.header)
    file.write('        Block block;\n')
    file.write('\n'.join(lineArray))
    file.write(constants.footer)

# WRITTEN_BOOK(387, 16)
def write_line():
    for item in items:
        itemS = "(new Item()).c(\""+item['name']+"\"));"
        if item['type'] == 'sword':
            itemS = "(new SonOyuncuSword()).damage("+item['damage']+").c(\"" + item['name'] + "\"));"
        elif item['type'] == 'helmet':
            itemS = "(new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 4, 0)).c(\"" + item['name'] + "\"));"
        elif item['type'] == 'chestplate':
            itemS = "(new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 4, 1)).c(\"" + item['name'] + "\"));"
        elif item['type'] == 'leggings':
            itemS = "(new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 4, 2)).c(\"" + item['name'] + "\"));"
        elif item['type'] == 'boots':
            itemS = "(new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 4, 3)).c(\"" + item['name'] + "\"));"
        #(new ItemSpade(Item.EnumToolMaterial.IRON)).c("shovelIron"));
        elif item['type'] == 'shovel':
            itemS = "(new ItemSpade(Item.EnumToolMaterial.EMERALD)).c(\"" + item['name'] +"\"));"
        elif item['type'] == 'pickaxe':
            itemS = "(new SonOyuncuPickaxe(Item.EnumToolMaterial.EMERALD)).c(\"" + item['name'] +"\"));"
        elif item['type'] == 'axe':
            itemS = "(new SonOyuncuAxe(Item.EnumToolMaterial.EMERALD)).c(\"" + item['name'] +"\"));"
        elif item['type'] == 'hoe':
            itemS = "(new ItemHoe(Item.EnumToolMaterial.EMERALD)).c(\"" + item['name'] +"\"));"
        elif item['type'] == 'block':
            #(new Block(Material.STONE, MaterialMapColor.d)).c(3.0F).b(15.0F).a(Block.i).c("whiteStone").a(CreativeModeTab.b)

            if 'fix_rotation' in item:
                if item['fix_rotation'] == 'cosmetic':
                    lineArray.append("        block = new SonOyuncuDirectional().c(\""+item['name']+"\");")
                elif item['fix_rotation'] == 'furnace':
                    lineArray.append("        block = new SonOyuncuFurnace().c(\""+item['name']+"\");")
            else:
                lineArray.append("        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength("+item['strength']+").durability("+item['durability']+").stepSound(Block.i).c(\""+item['name']+"\");")
            lineArray.append("        b(" + item['id'] + ", new MinecraftKey(\""+item['name']+"\"), block);")
            lineArray.append("        a(block, (new ItemBlock(block)));")
        if len(itemS) > 0 and item['type'] != 'block':
            lineArray.append('        ' + "a("+item['id']+", \""+item['name']+"\", " + itemS)

        

if __name__ == '__main__':
    if len(sys.argv) < 2:
        print("isim gir")
        pass
    items = json.load(open(sys.argv[1]))
    write_line()
    write_to_file(sys.argv[2])