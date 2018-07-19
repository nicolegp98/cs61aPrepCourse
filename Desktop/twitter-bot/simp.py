import tweepy
import random
import time
import datetime
from secrets import *



#Twitter needs all requests to use OAuth for authentication
auth = tweepy.OAuthHandler(CONSUMER_KEY, CONSUMER_SECRET)
auth.set_access_token(ACCESS_TOKEN, ACCCESS_T_SECRET);
api = tweepy.API(auth)


follower_list = []

#will follow anyone who follows the account
def followback():
    for follower in tweepy.Cursor(api.followers).items():
        try:
            follower.follow()
            follower_list.append(follower.screen_name)
        except tweepy.error.TweepError as e:
            print(e.reason)


#will unfollow anyone who unfollows the account

def unfollow():
    for follower in tweepy.Cursor(api.friends).items():
        if follower.screen_name not in follower_list:
            api.destroy_friendship(follower.screen_name)
        else:
            continue


def favemessage():
    for message in tweepy.Cursor(api.mentions_timeline).items():
        try:
            api.create_favorite(message.id)
        except:
            pass


#will write message on Twitter
def write_message(option):
    if option == 1 or option == 2:
          with open("simpy.txt, "r", encoding="utf-8-sig") as simpy:
            message = random.choice(simpy.readlines())
    else:
        with open ("dedications.txt", "r+", encoding = "utf-8") as file:
             pickedmessage = random.choice(dedications.readlines())


        dedicated = random.choice(follower_list)
        with open("followers_who_received_messages.txt", "r+", encoding="utf-8") as file:
             tweeted = []
             for username in file.readlines():
                 tweeted.append(username[:-1]) #appends the user to the back of the list
             while dedicated in tweeted:
                 dedicated = random.choice(follower_list) #keeps picking until follower no longer exists in list
             file.write(dedicated + "\n")

             message = pickedmessage + "@" + dedicated + "."

     return message


#will actually post the tweet
def tweet_poster():
    choice = random.randint(1, 3)
    api.update_status(write_message(choice))
    #to prevent exceeding usage limit; only tweets once every 4 hours
    while True:
        time.sleep(300)


if ___name___ = "__main__":
    followback()
    unfollow()
    favemessage()
    tweet_poster()
