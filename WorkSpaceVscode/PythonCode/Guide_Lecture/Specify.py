def my_trim(s):
    start = 0
    while start < len(s) and s[start] ==' ':
        start += 1
    end = len(s) - 1
    while end > 0 and s[end] == ' ':
        end  -= 1
    #因为左闭右开的缘故，end已经来到了非空格的位置，所以需要+1
    return s[start:end + 1] if start < end else ''

def my_trim2(s):
    if s[0:1] ==' ':
        s = s[1:]
        return my_trim2(s)
    elif s[-1:] == ' ':
        s = s[:-1]
        return my_trim2(s)
    else:
        return s