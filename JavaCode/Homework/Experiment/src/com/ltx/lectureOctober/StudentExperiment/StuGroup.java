package com.ltx.lectureOctober.StudentExperiment;



public class StuGroup implements MyGroup
{
	 private Student[] stu;
	 private int length;

	/**
	 * 构造函数，传入参数为学生数组的长度
	 * @param len
	 */
	public StuGroup(int len)
	{
		this.stu = new Student[len];//初始化学生数组
		this.length = 0;
	}

	/**
	 * 判断数组是否溢出
	 * @return
	 */
	private boolean isOverflow()
	{
		if(this.length<stu.length)
			return false;
		else
			return true;
	}
	
	public boolean isEmpty()    //判断数组是否为空
	{
		return this.length==0;
	}
	
	public boolean addStu(Student x)  //添加学生
	{
		if(isOverflow())
			return false;
		stu[length++]=x;
		return true;
	}

	/**
	 * 删除指定位置学生信息
	 * @param index 指定位置
	 * @return 返回被删除位置上学生的信息
	 */
	public Student removeStu(int index)  //
	{
		if(isEmpty())
		{
			System.out.println("学生表为空，删除失败");
			return null;
		}
		Student temp=stu[index-1];
		for(int i=index-1;i<this.length-1;i++)
		{
			stu[i]=stu[i+1];
		}
		this.length--;
		return temp;
	}

	/**
	 * 成绩排序
	 * @param x 当x=1时用数学成绩排序，x=2时用计算机成绩排序
	 */
	public void sort(int x)
	{
		if(x==1)
		{
			for (int i = 1; i < length; i++) {
				Student currentStudent = stu[i];
				double currentMathScore = currentStudent.getMathScore();
				int j = i - 1;

				while (j >= 0 && stu[j].getMathScore() > currentMathScore) {
					stu[j + 1] = stu[j];
					j--;
				}
				stu[j + 1] = currentStudent;
			}
		}
		else if(x==2)
		{
			for (int i = 1; i < length; i++) {
				Student currentStudent = stu[i];
				double currentComputerScore = currentStudent.getComputerScore();
				int j = i - 1;

				while (j >= 0 && stu[j].getComputerScore() > currentComputerScore) {
					stu[j + 1] = stu[j];
					j--;
				}
				stu[j + 1] = currentStudent;
			}
		 }
     }
	
	public void print()
	{
		if (isEmpty()) {
			System.out.println("学生表为空！");
		} else {
			for (int i = 0; i < length; i++) {
				Student student = stu[i];
				System.out.println("学号: " + student.getId() +
						", 姓名: " + student.getName() +
						", 数学成绩: " + student.getMathScore() +
						", 计算机成绩: " + student.getComputerScore());

				// 如果是研究生，还可以打印更多信息
				if (student instanceof Postgraduate) {
					Postgraduate pg = (Postgraduate) student;
					System.out.println(", 导师: " + pg.getTeacherName() +
							", 研究方向: " + pg.getSearch());
				}
			}
		}
	}
		
}
