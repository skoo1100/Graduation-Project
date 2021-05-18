
from bs4 import BeautifulSoup
import requests
import json
from flask import Flask, render_template, jsonify, request
app = Flask(__name__)

@app.route('/')
def home():
    ar=getNews()
    br=getRanking()

   # return render_template('Jobs_collection.html')
    #return "ddd"
    return render_template('index.html',data=ar,data2=br)

def getRanking():
    URL="https://www.jobkorea.co.kr/"    
    result = requests.get(URL)
    soup = BeautifulSoup(result.text, 'html.parser')
    divtag=soup.find("div",{"id":"ranking_carousel"})
    ultag=divtag.find("ul",{"class":"carousel-wrapper"})
    lilist=ultag.find_all("li")
    br=[]
    for l in lilist:
        #print(l)
        atag=l.find_all("a")
        count=0
        for a in atag:
            count+=1
            br.append([a.text,count])
            if count==10:
                break
        break
    #print(lilist)
    for i in br:
        print(i)



    print("?")
    return br


    
    
def getNews():
    page=1
    URL="https://www.jobkorea.co.kr/goodjob/tip/120001?schCtgr=120001&TipKwrdArray=%EC%A0%84%EA%B3%B5&TipKwrdArray=%EC%B7%A8%EC%A4%80%EC%83%9D&TipKwrdArray=%EC%95%8C%EB%B0%94%EC%83%9D&TipKwrdArray=%EC%8A%A4%ED%8E%99&TipKwrdArray=%EC%A4%91%EC%86%8C%EA%B8%B0%EC%97%85&TipKwrdArray=%EC%9D%B4%EC%8A%88&TipKwrdArray=%EB%82%98%EC%9D%B4&TipKwrdArray=%EC%A7%81%EC%9E%A5%EC%9D%B8&TipKwrdArray=%EA%B5%AC%EC%A7%81%ED%99%9C%EB%8F%99&TipKwrdArray=%EC%95%8C%EB%B0%94%EB%AA%AC&Page="
    result = requests.get(URL+str(page))
    soup = BeautifulSoup(result.text, 'html.parser')
    list_default = soup.find("div", {"id":"container"})
    jobs_page = list_default.find("ul", {"class":"joodJobList"})
    #print(jobs_page)
    ar=[]
    title=jobs_page.find_all("li")
    for alink in title:
        ahref=alink.find("a").get('href')
        titles=alink.find("strong").text.strip()
        if '\r\n' in titles: 
            titles=titles.split("\r\n")[0]

# baseurl=jobkorea.co.kr
        ar.append([ahref,titles])
        
    # for i in title:
    #     print(i.text.strip())
    # #print(ar)
    # for i in ar:
    #     print(i)
    #return render_template('views/message/managerMsglist.html'
    return ar
    #print(title)
if __name__ == '__main__':
    app.run('localhost', port=10038, debug=True)
    