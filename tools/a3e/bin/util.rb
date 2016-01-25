## Copyright (c) 2012-2013,
##  Tanzirul Azim <mazim002@cs.ucr.edu>
##  Iulian Neamtiu  <neamtiu@cs.ucr.edu>
## All rights reserved.
##
## Redistribution and use in source and binary forms, with or without
## modification, are permitted provided that the following conditions are met:
##
## 1. Redistributions of source code must retain the above copyright notice,
## this list of conditions and the following disclaimer.
##
## 2. Redistributions in binary form must reproduce the above copyright notice,
## this list of conditions and the following disclaimer in the documentation
## and/or other materials provided with the distribution.
##
## 3. The names of the contributors may not be used to endorse or promote
## products derived from this software without specific prior written
## permission.
##
## THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
## AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
## IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
## ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
## LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
## CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
## SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
## INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
## CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
## ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
## POSSIBILITY OF SUCH DAMAGE.

module UTIL
require 'fileutils'
	def UTIL.compare(file_name1, file_name2)
		is_same=FileUtils.compare_file(file_name1, file_name2);
	end
	
	def UTIL.extract_num(file_name)
		num=IO.readlines(file_name)
	end
	
	def UTIL.compare_output(file1, file2, file3)
		
		f1 = IO.readlines(file1).map(&:chomp)
		f2 = IO.readlines(file2).map(&:chomp)
		f3= (f1-f2)
		print "*******\n"
		print f3
		print "\n*******\n"
		File.open(file3,"w"){ |f| f.write((f1-f2).join("\n")) }
	
	end
end