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


### 开发版本记录
- feature-20210920分支添加记录文件
- feature-20210920分支对文件进行修改，提交本地仓库，但不push到远程仓库
- 好的，现在我要提交我的代码了

### 这是hotfix分支添加的文件
用命令的方式添加新建分支