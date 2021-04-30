
from bs4 import BeautifulSoup
import requests
import json
from flask import Flask, render_template, jsonify, request


from indeed import id_get_jobs
from saramin import sa_get_jobs
from job_korea import jk_get_jobs

app = Flask(__name__)


## HTML을 주는 부분
@app.route('/')
def home():
    ar=getNews()
   # return render_template('Jobs_collection.html')
    return render_template('Jobs_collection.html',data=ar)
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
    #print(ar)
    for i in ar:
        print(i)
    #return render_template('views/message/managerMsglist.html'
    return ar
    #print(title)

    
@app.route('/api/news', methods=['GET'])
def get_news():
    return ""


@app.route('/api/saramin', methods=['GET'])
def get_saramin_jobs():
    input_keyword_recieve = request.args.get('input_keyword_give')
    input_location_recieve = request.args.get('input_location_give')
    input_jobtype_recieve = request.args.get('input_jobtype_give')
    # print(input_keyword_recieve)
    # print(input_location_recieve)
    # print(input_jobtype_recieve)
    sa_jobs = sa_get_jobs(input_keyword_recieve, input_location_recieve, input_jobtype_recieve)
    # return sa_get_jobs()
    # return id_get_jobs()
    return jsonify ({'result':'success','sa_jobs':sa_jobs})
    


@app.route('/api/indeed', methods=['GET'])
def get_indeed_jobs():
    input_keyword_recieve = request.args.get('input_keyword_give')
    input_location_recieve = request.args.get('input_location_give')
    input_jobtype_recieve = request.args.get('input_jobtype_give')
    # print(input_keyword_recieve)
    # print(input_location_recieve)
    # print(input_jobtype_recieve)
    id_jobs = id_get_jobs(input_keyword_recieve, input_location_recieve, input_jobtype_recieve)
    # return sa_get_jobs()
    # return id_get_jobs()
    return jsonify ({'result':'success','id_jobs':id_jobs})
    
    

@app.route('/api/job_korea', methods=['GET'])
def get_job_korea_jobs():
    input_keyword_recieve = request.args.get('input_keyword_give')
    input_location_recieve = request.args.get('input_location_give')
    input_jobtype_recieve = request.args.get('input_jobtype_give')
    # print(input_keyword_recieve)
    # print(input_location_recieve)
    # print(input_jobtype_recieve)
    jk_jobs = jk_get_jobs(input_keyword_recieve, input_location_recieve, input_jobtype_recieve)
    # return sa_get_jobs()
    # return jk_get_jobs()
    return jsonify ({'result':'success','jk_jobs':jk_jobs})

@app.route('/api/total', methods=['GET'])
def get_total_jobs():
    # return sa_get_jobs()
    input_keyword_recieve = request.args.get('input_keyword_give')
    input_location_recieve = request.args.get('input_location_give')
    input_jobtype_recieve = request.args.get('input_jobtype_give')
    print(input_keyword_recieve)
    print(input_location_recieve)
    print(input_jobtype_recieve)
    jk_jobs = jk_get_jobs(input_keyword_recieve, input_location_recieve, input_jobtype_recieve)
    sa_jobs = sa_get_jobs(input_keyword_recieve, input_location_recieve, input_jobtype_recieve)
    id_jobs = id_get_jobs(input_keyword_recieve, input_location_recieve, input_jobtype_recieve)
    # print(type(jk_jobs), jk_jobs)
    # print(type(b))
    
    return jsonify ({'result':'success','jk_jobs':jk_jobs, 'sa_jobs':sa_jobs, 'id_jobs':id_jobs})

    
if __name__ == '__main__':
    app.run('localhost', port=10038, debug=True)
# print(news_craw())