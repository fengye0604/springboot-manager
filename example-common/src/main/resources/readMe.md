git 提交代码注意事项：
修改提交：
> 修改代码---commit---pull---解决冲突---push
> 所以提交到本地仓库后，不要急着push，一定要在push前线pull（拉取代码）一下
> 对应的纯命令模式是：修改代码---git add 修改文件 ---commit ---pull ---push

### 本地新建分支
> new branch
> 
> 修改代码 --- commit ---push
> 
> 通过以上三步就将代码推到远程仓库了

### 合并分支
现在有feature-20210920和master分支，需要将feature-20210920的更新代码合并到master上
实现步骤：
- feature-20210920分支修改代码---提交本地仓库---push到远程仓库
- 切换到master分支上，然后选中feature-20210920分支，merge into Current(合并到当前)
- 冲突解决 ---提交代码

### 删除分支
git branch -d 分支名称
注意事项
>如果是本地分支（即没有推向远端仓库的地址），直接使用上面的命令即可
> 
>如果是远程分支需要执行这个命令：git push origin --delete <分支名称> 如下，是删除远程分支feature-20210920
> 
>git push origin --delete feature-20210920



### 开发版本记录
- feature-20210920分支添加记录文件
- feature-20210920分支对文件进行修改，提交本地仓库，但不push到远程仓库
- 这里我做了修改，重新建立的分支是feature_20210921(命令的模式删除分支)分支，同时删除hotfix分支分支

