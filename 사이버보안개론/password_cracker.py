import hashlib
from itertools import product


# open and read files 
def read_files(file_path):

    with open(file_path,'r') as file:
        lines = file.readlines()
        return [line.rstrip("\n") for line in lines]
    
    return None


def generate_md5_hash(plain_password,salt):
    salted_password = plain_password + salt
    return hashlib.md5(salted_password.encode()).hexdigest()

def find_salt(plain_password,salt_list,hashes):

    # generate all possible hash passwords for all salt
    all_hashed_passwords = {generate_md5_hash(plain_password, salt):salt for salt in salt_list}

    # check if specific hashed_password in all_hashed_passwords
    for hashed_password in hashes: 
        if hashed_password in all_hashed_passwords: #O(1)
            return all_hashed_passwords[hashed_password]
     
    return None
    


def generate_salts(): #4-character
    salt_list = []
    characters ='abcdefghijklmnopqrstuvwxyz0123456789'
    combinations = product(characters,repeat=4) # generator

    for comb in combinations:
        salt_list.append(''.join(comb))

    return salt_list


# crack password by dictionary attacks
def crack_password(salt,hashes,dictionary):
    cracked_passwords = {}
    
    for i,hashed_password in enumerate(hashes):

        sequence_string = str(i+1)+"/"+str(LINES_OF_HASHED_FILE)+" "
        print(sequence_string,end='')

        for password in dictionary:
            hashed_attempt = generate_md5_hash(password,salt)
            if hashed_attempt == hashed_password: #cracking success 
                cracked_passwords[hashed_password] = password 
                print("password has been cracked, hashed: ", hashed_password, "cracked: ",password)
                break

        if hashed_password not in cracked_passwords:
            cracked_passwords[hashed_password]= None

    return cracked_passwords



HASHED_FILE_PATH = '1MillionPassword_hashed.txt'
WORD_FILE_PATH = '1MillionPassword_wordlist.txt'

hashes = read_files(HASHED_FILE_PATH)
dictionary = read_files(WORD_FILE_PATH)


LINES_OF_HASHED_FILE = len(hashes)


salt_list = generate_salts()
salt = find_salt(dictionary[0], salt_list, hashes)


cracked_passwords = crack_password(salt,hashes,dictionary)

# display cracked results
for i, (hashed_password, password) in enumerate(cracked_passwords.items()):
    print(i+1,"/",LINES_OF_HASHED_FILE,"password has been cracked, hashed: ", hashed_password, "cracked: ",password)