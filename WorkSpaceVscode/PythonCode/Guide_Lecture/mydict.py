class Dict(dict):
    def __init__(self,**kw):
        super().__init__(**kw)

    def __getattr__(self,key):
        try:
            return self[key]
        except:
            raise AttributeError('sfjs %s'% key)
        
    def __setattr(self,key,value):
        self[key] = value