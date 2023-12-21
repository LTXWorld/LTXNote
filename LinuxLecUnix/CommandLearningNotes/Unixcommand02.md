## Lnk

In Unix or Linux,we can use `lnk` command to create a symbol link or a hard link.

Before we start,we should better know these two kinds of link.

### Symbolic link

Just like the A shortcut on windows,it's not the real file,just a link to the real file.In Unix,we can create a symbol link by **`ln -s file1 file2`**(Use the -s parameter it means symbolic link)

<img src="../Pic/image-20231220162200340.png" alt="image-20231220162200340" style="zoom:50%;" />

In theory field,symbolic links point to another file or directory and do not contain actual file data but are **simply pointers to the file or directory they reference**;(In hard link we will talk a lot about link)

### Hard link

Hard link is as important as symbolic link,we can create a hard link about any files such like that:`ln file1 file2 `![image-20231220162846818](../Pic/image-20231220162846818.png)

Pay attention to this photo,we can find the hard link file is as same size as source file `Link1.java`,also 100B,even,those two have the same time!!!,Wow,so why?

Essentially,all files are essentially hard links,which means creating a new hard link for a file is just **creating another name by which the file can be called.**This does not consume additional disk sapce for the file data itself,but merely creats **another reference to the file's inode.**==As long as there is at least one hard link to the inode,the data remains on the disk.==

The filesystem keeps a count of how many hard links point to an inode,and the data blocks are not freed until this count reaches zero.

As we can see,**inode** is a very important concept in file's Link.It determines the life of a file.

With the `cp` command to use `ln`:<img src="../Pic/image-20231220163848185.png" alt="image-20231220163848185" style="zoom:50%;" />

Add the `-P` to make a symbolic link copy.(ps.Must the capital P )

## rm

We can use this command to delete any files or directory.But it can't cancel,so if you really want to use it,you'd better to add the parameter `rm -i file`,it will ask you whether to delete this file,it's a layer of insurance isn't it?

<img src="../Pic/image-20231220164914780.png" alt="image-20231220164914780" style="zoom:50%;" />

If you want to delete a directory,there are two situations about it:For empty directory,we can directly use this command to do it `rm directoryname` or `rmdir xxx`;Please remeber,`rmdir` is the command to remove or delete an **empty directory**.

But in most time,there always something in your directory,so we must add the parameter`rm -r directoryname`,it means it will recursively delete all files and subdirectories within the specified directory without confirmation by default.**(So,must be cautious!!!)**

## File

With this command you can get the **type of any files**.Just like this:<img src="../Pic/image-20231220165522841.png" alt="image-20231220165522841" style="zoom:67%;" />

Notice,`-vet`shows the version information about the `file`command itself,and the location of the `magic`file that `file` uses to identify file types.

## Cat(Tail\Head\more\less)

We can use this command to check the file's content.And we can also use `more `and `less`command to look through the whole content.<img src="../Pic/image-20231220170018674.png" alt="image-20231220170018674" style="zoom:50%;" />

We can also use `tail head `to get the specific part of the file.

## Notes:

Use the `man xxx` to get the help about command xxx,to use the specific parameters you want.